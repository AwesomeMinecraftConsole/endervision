package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

import kotlinx.coroutines.flow.StateFlow

interface EnderVisionService {
    suspend fun connect()
    fun disconnect()
    fun sendCommand(command: Command)
    fun sendOperation(operation: Operation)
    val isConnecting: StateFlow<Boolean>
}