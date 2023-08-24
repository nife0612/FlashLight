package com.example.flashlightxml.domain.usecase

import com.example.flashlightxml.data.Data
import kotlinx.coroutines.delay

// Класс для сигнала SOS
class SOSUseCase(private val data: Data) {

    private val numOfFlashesInSignal = 3

    private fun sosSignal() {
        flash(500L)
        //delay(100L)
        flash(1000L)
        //delay(100L)
        flash(500L)
    }

    private fun flash(timeMillis: Long) {
        data.manager.setTorchMode(data.manager.cameraIdList[0], true)
        //delay(timeMillis)
        data.manager.setTorchMode(data.manager.cameraIdList[0], false)
    }

    public fun execute(){
        sosSignal()
    }

}