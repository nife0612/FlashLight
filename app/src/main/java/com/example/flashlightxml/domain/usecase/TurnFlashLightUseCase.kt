package com.example.flashlightxml.domain.usecase


import android.hardware.camera2.CameraAccessException
import android.os.Build
import android.util.Log
import com.example.flashlightxml.data.Data

// Класс для включения/выключения фонарика

// Возможно стоит разделить включение и выключение на разные классы
class TurnFlashLightUseCase(private val data: Data) {
    private var lightFlag: Boolean = false

    private fun lightOn() {
        try {
            data.manager.setTorchMode(data.manager.cameraIdList[0], true)
            lightFlag = true
        } catch (e: CameraAccessException) {
            Log.e("CameraErrror", e.toString())
        }
    }

    private fun lightOff() {
        try {
            data.manager.setTorchMode(data.manager.cameraIdList[0], false)
            lightFlag = false
        } catch (e: CameraAccessException) {
            Log.e("CameraError", e.toString())
        }
    }

    public fun execute(){
        if(lightFlag) {
            lightOff()
        } else {
            lightOn()
        }
    }

}