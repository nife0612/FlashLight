package com.example.flashlightxml.presentanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashlightxml.databinding.ActivityMainBinding
import com.example.flashlightxml.domain.usecase.ExitFromAppUseCase

class MainActivity : AppCompatActivity() {

    // Создаю ViewBinding (https://developer.android.com/topic/libraries/view-binding)
    private lateinit var binding : ActivityMainBinding

    private val exitFromAppUseCase = ExitFromAppUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Создаю ViewBinding (https://developer.android.com/topic/libraries/view-binding)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewBinding вместо findViewByID
        binding.exitButton.setOnClickListener{
            exitFromAppUseCase.execute()
        }
    }


}