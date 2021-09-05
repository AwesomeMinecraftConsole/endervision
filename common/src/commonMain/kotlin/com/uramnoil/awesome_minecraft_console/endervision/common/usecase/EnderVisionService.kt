package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

interface EnderVisionService {
    fun sendCommand(command: Command)
    fun sendOperation(operation: Operation)
}