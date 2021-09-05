package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

fun interface SendCommandUseCaseInputPort {
    fun execute(command: Command)
}