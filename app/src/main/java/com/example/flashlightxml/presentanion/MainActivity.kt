package com.example.flashlightxml.presentanion

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashlightxml.domain.model.CameraManagerData
import com.example.flashlightxml.databinding.ActivityMainBinding
import com.example.flashlightxml.domain.usecase.ExitFromAppUseCase
import com.example.flashlightxml.domain.usecase.SOSUseCase
import com.example.flashlightxml.domain.usecase.TurnFlashLightUseCase

class MainActivity : AppCompatActivity() {

    // Создаю ViewBinding (https://developer.android.com/topic/libraries/view-binding)
    private lateinit var binding : ActivityMainBinding

    private val exitFromAppUseCase = ExitFromAppUseCase()

    private var isFlashLightOn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Создаю ViewBinding (https://developer.android.com/topic/libraries/view-binding)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = this.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraManagerData = CameraManagerData(manager)
        val turnFlashLightUseCase = TurnFlashLightUseCase(cameraManagerData)
        val sosUseCase = SOSUseCase(cameraManagerData)

        // ViewBinding вместо findViewByID
        binding.exitButton.setOnClickListener {
            exitFromAppUseCase.execute()
        }

        binding.button2.setOnClickListener {
            sosUseCase.execute()
        }

        binding.powerButton.setOnClickListener {
            when(isFlashLightOn) {
                true -> turnFlashLightUseCase.execute(false)
                false -> turnFlashLightUseCase.execute(true)
            }
            isFlashLightOn = !isFlashLightOn
        }

    }

}