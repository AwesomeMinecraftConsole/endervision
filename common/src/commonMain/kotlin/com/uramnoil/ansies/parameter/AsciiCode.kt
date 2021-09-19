package com.uramnoil.ansies.parameter

import com.uramnoil.ansies.parameter.EscapeParameter

enum class AsciiControlCharacter(val abbr: String, val c0: Int) {
    Null("Nul", 0x00) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    Bell("BEL", 0x07) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    Backspace("BS", 0x08) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    HorizontalTab("HT", 0x09) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    LineFeed("LF", 0x0A) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    VerticalTab("VT", 0x0B) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    FormFeed("FF", 0x0C) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    CarriageReturn("CR", 0x0D) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    ControlZ("SUB", 0x1A) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    },
    Escape("ESC", 0x1B) {
        override fun parse(argument: String): AsciiCode {
            return Escape(EscapeParameter.parse(argument))
        }
    },
    DEL("DEL", 0x7F) {
        override fun parse(argument: String): AsciiCode {
            TODO("Not yet implemented")
        }
    }, ;
    fun build(): String = Char(c0).toString()
    abstract fun parse(argument: String): AsciiCode
}

sealed class AsciiCode {
    abstract val asciiControlCharacter: AsciiControlCharacter
    abstract fun build(): String
}

val asciiControlCharacterMap = AsciiControlCharacter.values().associateBy { Char(it.c0) }

fun AsciiCode.parse(string: String): AsciiCode {
    val controlType = string.first()
    val argument = string.drop(1)
    return asciiControlCharacterMap[controlType]?.parse(string) ?: throw IllegalArgumentException("doesn't match ant parameters")
}