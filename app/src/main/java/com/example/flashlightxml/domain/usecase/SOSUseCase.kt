package com.example.flashlightxml.domain.usecase


import com.example.flashlightxml.domain.repository.FlashLightRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Класс для сигнала SOS
class SOSUseCase(private val repository: FlashLightRepository) {

    private val camManager= repository.get().camManager

    companion object {
        private const val COUNT_OF_FLASHES = 9
        private const val WAITING = 100L
        private const val SHORT = 500L
        private const val LONG = 1000L
    }

    private suspend fun sosSignal() {
        var counter = 1
        var isLongFlash = false
        while(counter <= COUNT_OF_FLASHES) {
            when(isLongFlash) {
                true -> flash(LONG)
                false -> flash(SHORT)
            }
            delay(WAITING)
            if(counter % 3 == 0) isLongFlash = !isLongFlash
            counter++
        }
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