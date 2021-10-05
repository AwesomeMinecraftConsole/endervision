package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

interface EnderVisionConnectionController {
    suspend fun connect()
    suspend fun disconnect()
}