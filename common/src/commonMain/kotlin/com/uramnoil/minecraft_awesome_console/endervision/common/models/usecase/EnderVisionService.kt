package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface EnderVisionService {
    fun sendCommand(command: Command)
    fun sendOperation(operation: Operation)
}