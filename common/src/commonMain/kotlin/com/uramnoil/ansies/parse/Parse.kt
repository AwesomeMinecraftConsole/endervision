package com.uramnoil.ansies.parse

import com.uramnoil.ansies.AsciiCodeOrStringSequence
import com.uramnoil.ansies.parameter.AsciiCode
import com.uramnoil.ansies.parameter.AsciiControlCharacter

val asciiControlCharacterMap = AsciiControlCharacter.values().map {
    Char(it.c0) to it
}

sealed class RowAsciiCodeOrString {
    data class AsciiCode(val asciiCode: kotlin.String) : RowAsciiCodeOrString()
    data class String(val string: kotlin.String) : RowAsciiCodeOrString()
}

val regex
    get() = """[\x00-\x1A\x1C-\x1F]|(\x1B([@-Z\\-_]))|(\x1B\[|\x9B)[0-?]*[ -/]*[@-~]""".toRegex()

fun removeAnsi(string: String): String {
    return regex.replace(string, "")
}

class RowAsciiCodeOrStringSequence(val sequence: List<RowAsciiCodeOrString>)

fun toRowAsciiCodeStringOrStringSequence(string: String): RowAsciiCodeOrStringSequence {
    val mutableList = mutableListOf<RowAsciiCodeOrString>()
    val asciiCodes = regex.find(string) ?: return RowAsciiCodeOrStringSequence(listOf(RowAsciiCodeOrString.String(string)))
    var index = 0
    asciiCodes.groupValues.forEach {
        val codeIndex = string.indexOf(it, startIndex = index)
        val sliced = string.slice(index..codeIndex)
        if (sliced != "") {
            mutableList.add(RowAsciiCodeOrString.String(sliced))
        }
        mutableList.add(RowAsciiCodeOrString.AsciiCode(it))
        index = codeIndex + it.length
    }
    val sliced = string.slice(index..string.lastIndex)
    if (sliced != "") {
        mutableList.add(RowAsciiCodeOrString.String(sliced))
    }

    return RowAsciiCodeOrStringSequence(mutableList)
}

fun RowAsciiCodeOrStringSequence.toAsciiCodeOrString(): AsciiCodeOrStringSequence {
    return AsciiCodeOrStringSequence(sequence.map {
        when (it) {
            is RowAsciiCodeOrString.String -> {
                com.uramnoil.ansies.AsciiCodeOrString.String(it.string)
            }
            is RowAsciiCodeOrString.AsciiCode -> {
                com.uramnoil.ansies.AsciiCodeOrString.AsciiCode(AsciiCode.parse(it.asciiCode))
            }
        }
    })
}

fun parseToAnsi(string: String): AsciiCodeOrStringSequence = toRowAsciiCodeStringOrStringSequence(string).toAsciiCodeOrString()

fun String.ansi() = parseToAnsi(this)