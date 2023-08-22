package com.example.flashlightxml.domain.usecase

import android.content.Context
import android.hardware.Camera

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.util.Log
import com.example.flashlightxml.data.Data


// Класс для включения/выключения фонарика

// Возможно стоит разделить включение и выключение на разные классы
class TurnFlashLightUseCase(private val data: Data) {
    private fun lightOn() {
        try {
            var cameraId: String? = null
            cameraId = data.manager.cameraIdList[0]
            data.manager.setTorchMode(cameraId, true)
        } catch (e: CameraAccessException) {
            Log.e("CameraErrror", e.toString())
        }
    }

    public fun execute(){lightOn()}

}