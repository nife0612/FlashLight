package com.example.flashlightxml.domain.model

import android.content.Context
import android.hardware.camera2.CameraManager

data class FlashLightModel(val context: Context?, var isFlashLightOn: Boolean = false)
