package com.example.flashlightxml.domain.usecase

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.util.Log
import com.example.flashlightxml.domain.repository.FlashLightRepository

class TurnFlashLightUseCase(private val repository: FlashLightRepository) {

    fun execute() {

        val camManager =
            repository.get().context?.getSystemService(Context.CAMERA_SERVICE) as CameraManager

        try {

            camManager.setTorchMode(camManager.cameraIdList[0], repository.turnLightMode())

        } catch (e: CameraAccessException) {

            Log.e("LightError_${if (repository.turnLightMode()) "on" else "off"}", e.toString())

        }
    }

}