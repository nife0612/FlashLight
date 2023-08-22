package com.example.flashlightxml.presentanion

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.flashlightxml.data.Data
import com.example.flashlightxml.databinding.ActivityMainBinding
import com.example.flashlightxml.domain.usecase.ExitFromAppUseCase
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

        val manager = this.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val data = Data(manager)
        val turnFlashLightUseCase = TurnFlashLightUseCase(data)

        // ViewBinding вместо findViewByID
        binding.exitButton.setOnClickListener {
            exitFromAppUseCase.execute()
        }

        //https://www.tutorialspoint.com/how-to-turn-on-flashlight-programmatically-in-android-using-kotlin
        //https://developer.android.com/reference/android/widget/RadioGroup
        //binding.powerButton.setOnCheckedChangeListener

        binding.powerButton.setOnClickListener {
            turnFlashLightUseCase.execute()
        }

    }

}