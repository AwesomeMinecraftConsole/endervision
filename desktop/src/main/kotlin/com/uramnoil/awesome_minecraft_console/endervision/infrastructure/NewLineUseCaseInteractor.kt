package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Line
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.NewLineUseCaseInputPort
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.NewLineUseCaseOutputPort

class NewLineUseCaseInteractor(private val outputPort: NewLineUseCaseOutputPort) : NewLineUseCaseInputPort {
    override fun execute(line: String) {
        outputPort.handle(Line(line))
    }
}