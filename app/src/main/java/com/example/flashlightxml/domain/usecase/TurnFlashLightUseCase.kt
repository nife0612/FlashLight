package com.example.flashlightxml.domain.usecase

import android.hardware.camera2.CameraAccessException
import android.util.Log
import com.example.flashlightxml.domain.repository.FlashLightRepository

class TurnFlashLightUseCase(private val repository: FlashLightRepository) {

    fun execute() {
        try {
            repository.get().manager
                .setTorchMode(repository.get().manager.cameraIdList[0], repository.turnLightMode())
        } catch (e: CameraAccessException) {
            Log.e("LightError_${if (repository.turnLightMode()) "on" else "off"}", e.toString())
        }
    }

}