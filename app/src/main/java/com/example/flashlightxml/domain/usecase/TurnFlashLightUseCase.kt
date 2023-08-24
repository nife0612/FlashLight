package com.example.flashlightxml.domain.usecase

import android.hardware.camera2.CameraAccessException
import android.util.Log
import com.example.flashlightxml.data.Data

class TurnFlashLightUseCase(private val data: Data) {

    public fun execute(turnLight: Boolean){
        try {
            data.manager.setTorchMode(data.manager.cameraIdList[0], turnLight)
        } catch (e: CameraAccessException) {
            Log.e("LightError_${if(turnLight) "on" else "off"}", e.toString())
        }
    }

}