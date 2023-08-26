package com.example.flashlightxml.domain.usecase

import kotlin.system.exitProcess


class ExitFromAppUseCase {

    fun execute() {
        exitProcess(0)
    }

}