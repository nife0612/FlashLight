package com.example.flashlightxml.domain.usecase

import android.hardware.camera2.CameraAccessException
import android.util.Log
import com.example.flashlightxml.data.repository.FlashLightRepositoryImpl

class TurnFlashLightUseCase(private val repository: FlashLightRepositoryImpl) {

    public fun execute(){
        try {
           repository.getManager().setTorchMode(repository.getManager().cameraIdList[0], repository.turnFlashLight())
        } catch (e: CameraAccessException) {
            Log.e("LightError_${if(repository.turnFlashLight()) "on" else "off"}", e.toString())
        }
    }

}