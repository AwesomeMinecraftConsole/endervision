package com.uramnoil.ansies.parse

import com.uramnoil.ansies.AsciiCodeOrStringSequence
import com.uramnoil.ansies.parameter.AsciiCode
import com.uramnoil.ansies.parameter.AsciiControlCharacter

val asciiControlCharacterMap = AsciiControlCharacter.values().map {
    Char(it.c0) to it
}

sealed class RawAsciiCodeOrString {
    data class AsciiCode(val asciiCode: kotlin.String) : RawAsciiCodeOrString()
    data class String(val string: kotlin.String) : RawAsciiCodeOrString()
}

val regex
    get() = """[\x00-\x1A\x1C-\x1F]|(\x1B([@-Z\\-_]))|(\x1B\[|\x9B)[0-?]*[ -/]*[@-~]""".toRegex()

fun removeAnsi(string: String): String {
    return regex.replace(string, "")
}

class RawAsciiCodeOrStringSequence(val sequence: List<RawAsciiCodeOrString>)

fun toRawAsciiCodeStringOrStringSequence(string: String): RawAsciiCodeOrStringSequence {
    val mutableList = mutableListOf<RawAsciiCodeOrString>()
    val asciiCodes = regex.find(string) ?: return RawAsciiCodeOrStringSequence(listOf(RawAsciiCodeOrString.String(string)))
    var index = 0
    asciiCodes.groupValues.forEach {
        val codeIndex = string.indexOf(it, startIndex = index)
        val sliced = string.slice(index..codeIndex)
        if (sliced != "") {
            mutableList.add(RawAsciiCodeOrString.String(sliced))
        }
        mutableList.add(RawAsciiCodeOrString.AsciiCode(it))
        index = codeIndex + it.length
    }
    val sliced = string.slice(index..string.lastIndex)
    if (sliced != "") {
        mutableList.add(RawAsciiCodeOrString.String(sliced))
    }

    return RawAsciiCodeOrStringSequence(mutableList)
}

fun RawAsciiCodeOrStringSequence.toAsciiCodeOrString(): AsciiCodeOrStringSequence {
    return AsciiCodeOrStringSequence(sequence.map {
        when (it) {
            is RawAsciiCodeOrString.String -> {
                com.uramnoil.ansies.AsciiCodeOrString.String(it.string)
            }
            is RawAsciiCodeOrString.AsciiCode -> {
                com.uramnoil.ansies.AsciiCodeOrString.AsciiCode(AsciiCode.parse(it.asciiCode))
            }
        }
    })
}

fun parseToAnsi(string: String): AsciiCodeOrStringSequence = toRawAsciiCodeStringOrStringSequence(string).toAsciiCodeOrString()

fun String.ansi() = parseToAnsi(this)