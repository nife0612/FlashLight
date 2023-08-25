package com.example.flashlightxml.presentanion

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.getSystemService
import com.example.flashlightxml.data.repository.FlashLightRepositoryImpl
import com.example.flashlightxml.domain.model.FlashLightModel
import com.example.flashlightxml.databinding.ActivityMainBinding
import com.example.flashlightxml.domain.usecase.ExitFromAppUseCase
import com.example.flashlightxml.domain.usecase.SOSUseCase
import com.example.flashlightxml.domain.usecase.TurnFlashLightUseCase

class MainActivity : AppCompatActivity() {

    // Создаю ViewBinding (https://developer.android.com/topic/libraries/view-binding)
    private lateinit var binding : ActivityMainBinding


    private val exitFromAppUseCase = ExitFromAppUseCase()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Создаю ViewBinding (https://developer.android.com/topic/libraries/view-binding)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flashLightModel = FlashLightModel(this.getSystemService(Context.CAMERA_SERVICE) as CameraManager)

        val repository = FlashLightRepositoryImpl(flashLightModel)

        val turnFlashLightUseCase = TurnFlashLightUseCase(repository)
        val sosUseCase = SOSUseCase(repository)


        // ViewBinding вместо findViewByID
        binding.exitButton.setOnClickListener {
            exitFromAppUseCase.execute()
        }

        binding.button2.setOnClickListener {
            sosUseCase.execute()
        }

        binding.powerButton.setOnClickListener {
            turnFlashLightUseCase.execute()
        }

    }




}