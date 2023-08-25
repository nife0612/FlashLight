package com.example.flashlightxml.domain.usecase

import com.example.flashlightxml.domain.repository.FlashLightRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Класс для сигнала SOS
class SOSUseCase(private val repository: FlashLightRepository) {

    private val numOfFlashesInSignal = 3

    private suspend fun sosSignal() {
        flash(500L)
        delay(100L)
        flash(1000L)
        delay(100L)
        flash(500L)
    }

    private suspend fun flash(timeMillis: Long) {
        repository.get().manager.setTorchMode(repository.get().manager.cameraIdList[0], true)
        delay(timeMillis)
        repository.get().manager.setTorchMode(repository.get().manager.cameraIdList[0], false)
    }

    fun execute() = runBlocking {
        launch {
            sosSignal()
        }
    }

}