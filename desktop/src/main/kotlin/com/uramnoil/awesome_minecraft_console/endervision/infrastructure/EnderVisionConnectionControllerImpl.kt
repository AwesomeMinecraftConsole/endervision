package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionConnectionController
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionService

class EnderVisionConnectionControllerImpl(private val service: EnderVisionService) : EnderVisionConnectionController {
    override suspend fun connect() {
        service.connect()
    }

    override suspend fun disconnect() {
        service.disconnect()
    }
}