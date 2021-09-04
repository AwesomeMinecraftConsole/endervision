package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface ReceivedLineUseCaseInputPort {
    fun execute(line: String)
}

interface ReceivedLineUseCaseOutputPort {
    fun handle(line: Line)
}