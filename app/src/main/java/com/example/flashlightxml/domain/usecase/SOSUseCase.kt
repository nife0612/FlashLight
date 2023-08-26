package com.example.flashlightxml.domain.usecase


import com.example.flashlightxml.domain.repository.FlashLightRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

import com.example.flashlightxml.domain.model.TimeDelay.SHORT
import com.example.flashlightxml.domain.model.TimeDelay.WAITING
import com.example.flashlightxml.domain.model.TimeDelay.Long



// Класс для сигнала SOS
class SOSUseCase(private val repository: FlashLightRepository) {

    private val camManager= repository.get().camManager
    private val numOfFlashesInSignal = 3

    private suspend fun sosSignal() {
        flash(WAITING)
        delay(SHORT)
        flash(Long)
        delay(SHORT)
        flash(SHORT)
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