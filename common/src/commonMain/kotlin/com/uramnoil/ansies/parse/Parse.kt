package com.uramnoil.ansies.parse

import com.uramnoil.ansies.AnsiEscapeSequenceOrString
import com.uramnoil.ansies.AsciiCodeOrStringSequence
import com.uramnoil.ansies.parameter.AsciiControlCharacter
import com.uramnoil.ansies.parameter.AsciiControlCharacterType

val asciiControlCharacterTypeMap = AsciiControlCharacterType.values().map {
    Char(it.c0) to it
}

sealed class RawAnsiEscapeSequenceOrString {
    abstract val string: kotlin.String

    data class AsciiCode(override val string: kotlin.String) : RawAnsiEscapeSequenceOrString()
    data class String(override val string: kotlin.String) : RawAnsiEscapeSequenceOrString()
}

val regex
    get() = """[\x00-\x1A\x1C-\x1F]|(?:\x1B|\\e)[@-Z\\-_]|(?:\\e\[|\x1B\[|\x9B)(?:[0-?]*[ -/]?)*[@-~]""".toRegex()

fun removeAnsiSequence(string: String): String {
    return regex.replace(string, "")
}

class RawAsciiEscapeSequenceOrStringSequence(val sequence: List<RawAnsiEscapeSequenceOrString>) {
    fun toAsciiCodeOrString(): AsciiCodeOrStringSequence {
        return AsciiCodeOrStringSequence(sequence.map {
            when (it) {
                is RawAnsiEscapeSequenceOrString.String -> {
                    AnsiEscapeSequenceOrString.String(it.string)
                }
                is RawAnsiEscapeSequenceOrString.AsciiCode -> {
                    kotlin.runCatching { AsciiControlCharacter.parse(it.string) }.fold(
                        onSuccess = { ansi -> AnsiEscapeSequenceOrString.AnsiEscapeSequence(ansi) },
                        onFailure = { _ -> AnsiEscapeSequenceOrString.String(it.string) }
                    )
                }
            }
        })
    }
}

fun findAnsiSequences(string: String): List<String> = regex.findAll(string).map { it.value }.toList()

fun MutableList<RawAnsiEscapeSequenceOrString>.addStringIfNotEmpty(string: String) {
    if (string.isNotEmpty()) {
        add(RawAnsiEscapeSequenceOrString.String(string))
    }
}

fun MutableList<RawAnsiEscapeSequenceOrString>.addAnsi(string: String) {
    add(RawAnsiEscapeSequenceOrString.AsciiCode(string))
}

fun toRawAsciiCodeStringOrStringSequence(string: String): RawAsciiEscapeSequenceOrStringSequence {
    val mutableList = mutableListOf<RawAnsiEscapeSequenceOrString>()
    val asciiCodes = findAnsiSequences(string)
    var left = string
    asciiCodes.forEach {
        val stringBeforeAnsiCode = left.take(left.indexOf(it))
        mutableList.addStringIfNotEmpty(stringBeforeAnsiCode)
        mutableList.addAnsi(it)
        left = left.drop(stringBeforeAnsiCode.count() + it.count())
    }
    mutableList.addStringIfNotEmpty(left)

    return RawAsciiEscapeSequenceOrStringSequence(mutableList)
}

fun parseToAnsi(string: String): AsciiCodeOrStringSequence =
    toRawAsciiCodeStringOrStringSequence(string).toAsciiCodeOrString()

fun String.ansi() = parseToAnsi(this)

fun String.removeAnsi() = removeAnsiSequence(this)