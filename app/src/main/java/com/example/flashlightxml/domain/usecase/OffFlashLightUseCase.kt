package com.example.flashlightxml.domain.usecase


import android.hardware.camera2.CameraAccessException
import android.util.Log
import com.example.flashlightxml.data.Data

class OffFlashLightUseCase(private val data: Data) {

    public fun execute(){
        try {
            data.manager.setTorchMode(data.manager.cameraIdList[0], false)
        } catch (e: CameraAccessException) {
            Log.e("CameraError", e.toString())
        }
    }

}