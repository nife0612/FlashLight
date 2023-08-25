package com.example.flashlightxml.domain.model

import android.hardware.camera2.CameraManager

data class FlashLightModel(val camManager: CameraManager, var isFlashLightOn: Boolean = false)
