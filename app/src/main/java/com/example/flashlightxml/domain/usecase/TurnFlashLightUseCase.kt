package com.example.flashlightxml.domain.usecase

import android.hardware.camera2.CameraAccessException
import android.util.Log
import com.example.flashlightxml.domain.repository.FlashLightRepository

class TurnFlashLightUseCase(private val repository: FlashLightRepository) {

    private val camManager = repository.get().camManager

    fun execute() {
        try {

            camManager.setTorchMode(camManager.cameraIdList[0], repository.turnLightMode())

        } catch (e: CameraAccessException) {

            Log.e("LightError_${if (repository.turnLightMode()) "on" else "off"}", e.toString())

        }
    }

}