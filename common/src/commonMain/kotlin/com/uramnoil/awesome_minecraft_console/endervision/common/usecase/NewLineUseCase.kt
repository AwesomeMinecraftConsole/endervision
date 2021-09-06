package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

fun interface NewLineUseCaseInputPort {
    fun execute(line: String)
}

fun interface NewLineUseCaseOutputPort {
    fun handle(line: String)
}