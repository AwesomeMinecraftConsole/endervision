package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface ReceivedLineUsecaseInputPort {
    fun execute(line: String)
}

interface ReceivedLineUsecaseOutputPort {
    fun handle(line: String)
}

