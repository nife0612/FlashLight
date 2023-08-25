package com.example.flashlightxml.domain.usecase

import kotlin.system.exitProcess

// Класс для выхода из приложения

// Архетектура https://www.youtube.com/playlist?list=PLeF3l86ZMVkLQbdRL6Ra4cr_cmPROj94y
class ExitFromAppUseCase {

    fun execute() {
        // Закрыть приложение
        exitProcess(0)
    }

}