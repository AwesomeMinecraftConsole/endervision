package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

fun interface SendCommandUseCaseInputPort {
    fun execute(command: Command)
}