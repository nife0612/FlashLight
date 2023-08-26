package com.example.flashlightxml.presentanion

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flashlightxml.data.repository.FlashLightRepositoryImpl
import com.example.flashlightxml.databinding.ActivityMainBinding
import com.example.flashlightxml.domain.model.FlashLightModel
import com.example.flashlightxml.domain.usecase.ExitFromAppUseCase
import com.example.flashlightxml.domain.usecase.SOSUseCase
import com.example.flashlightxml.domain.usecase.TurnFlashLightUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val repository by lazy {
        FlashLightRepositoryImpl(
            FlashLightModel(
                camManager = applicationContext?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
            )
        )
    }

    private val turnFlashLightUseCase by lazy { TurnFlashLightUseCase(repository) }
    private val sosUseCase by lazy { SOSUseCase(repository) }
    private val exitFromAppUseCase = ExitFromAppUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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