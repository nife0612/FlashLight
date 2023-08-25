package com.example.flashlightxml.domain.usecase

import com.example.flashlightxml.domain.model.CameraManagerData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Класс для сигнала SOS
class SOSUseCase(private val cameraManagerData: CameraManagerData) {

    private val numOfFlashesInSignal = 3

    private suspend fun sosSignal() {
        flash(500L)
        val a = null
        delay(100L)
        flash(1000L)
        delay(100L)
        flash(500L)
    }

    private suspend fun flash(timeMillis: Long) {
        cameraManagerData.manager.setTorchMode(cameraManagerData.manager.cameraIdList[0], true)
        delay(timeMillis)
        cameraManagerData.manager.setTorchMode(cameraManagerData.manager.cameraIdList[0], false)
    }

    public fun execute() = runBlocking {
        launch {
            sosSignal()
        }
    }

}