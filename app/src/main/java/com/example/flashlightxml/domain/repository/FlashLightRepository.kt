package com.example.flashlightxml.domain.repository

import com.example.flashlightxml.domain.model.FlashLightModel

interface FlashLightRepository {

    fun save(flashLightModel: FlashLightModel)

    fun get(): FlashLightModel

    fun turnLightMode(): Boolean
}