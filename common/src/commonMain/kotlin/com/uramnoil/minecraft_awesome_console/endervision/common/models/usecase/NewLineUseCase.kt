package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface NewLineUseCaseInputPort {
    fun execute(line: String)
}

interface NewLineUseCaseOutputPort {
    fun handle(line: Line)
}