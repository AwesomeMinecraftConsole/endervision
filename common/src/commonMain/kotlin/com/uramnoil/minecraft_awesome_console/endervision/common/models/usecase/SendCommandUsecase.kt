package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface SendCommandUseCaseInputPort {
    fun execute(command: Command)
}