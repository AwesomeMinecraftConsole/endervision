package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.NewLineUseCaseInputPort
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.NewLineUseCaseOutputPort

class NewLineUseCaseInteractor(private val outputPort: NewLineUseCaseOutputPort) : NewLineUseCaseInputPort {
    override fun execute(line: Line) {
        outputPort.handle(line)
    }
}