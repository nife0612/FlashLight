package com.example.flashlightxml.domain.usecase

import android.content.Context
import android.hardware.camera2.CameraManager
import com.example.flashlightxml.domain.repository.FlashLightRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Класс для сигнала SOS
class SOSUseCase(private val repository: FlashLightRepository) {

    private val camManager= repository.get().camManager
    private val numOfFlashesInSignal = 3

    private suspend fun sosSignal() {
        flash(500L)
        delay(100L)
        flash(1000L)
        delay(100L)
        flash(500L)
    }

    private suspend fun flash(timeMillis: Long) {
        camManager.setTorchMode((camManager.cameraIdList[0]), true)
        delay(timeMillis)
        camManager.setTorchMode(camManager.cameraIdList[0], false)
    }

    fun execute() = runBlocking {
        launch {
            sosSignal()
        }
    }

}