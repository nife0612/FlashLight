package com.example.flashlightxml.data.repository

import android.hardware.camera2.CameraManager
import com.example.flashlightxml.domain.model.FlashLightModel
import com.example.flashlightxml.domain.repository.FlashLightRepository

class FlashLightRepositoryImpl(flashLightModel: FlashLightModel) : FlashLightRepository {

    private var flModel : FlashLightModel
    init{
        flModel = flashLightModel
    }

    override fun save(flashLightModel: FlashLightModel) {
        flModel = flashLightModel
    }

    override fun get() : FlashLightModel {
       return flModel
    }

    fun getManager() : CameraManager{
        return flModel.manager
    }

    fun turnFlashLight(): Boolean{
        flModel.isFlashLightOn = !flModel.isFlashLightOn
        return flModel.isFlashLightOn
    }
}