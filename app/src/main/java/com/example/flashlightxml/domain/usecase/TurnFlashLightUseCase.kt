package com.example.flashlightxml.domain.usecase

import android.hardware.camera2.CameraAccessException
import android.util.Log
import com.example.flashlightxml.domain.model.CameraManagerData

class TurnFlashLightUseCase(private val cameraManagerData: CameraManagerData) {

    public fun execute(turnLight: Boolean){
        try {
            cameraManagerData.manager.setTorchMode(cameraManagerData.manager.cameraIdList[0], turnLight)
        } catch (e: CameraAccessException) {
            Log.e("LightError_${if(turnLight) "on" else "off"}", e.toString())
        }
    }

}