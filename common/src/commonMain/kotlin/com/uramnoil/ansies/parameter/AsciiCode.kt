package com.uramnoil.ansies.parameter

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
    companion object {
        private val c0Map = AsciiControlCharacter.values().associateBy { Char(it.c0) }
        private val c1Map = EscapeParameterType.values().associateBy { Char(it.c1) }

        fun parse(string: String): AsciiCode {
            val controlType = string.first()
            val c0 = c0Map[controlType]
            val c1 = c1Map[controlType]
            var asciiCode: AsciiCode? = null
            if (c0 != null) {
                val argument = string.drop(1)
                asciiCode = c0.parse(argument)
            } else if (c1 != null) {
                val argument = string.drop(1)
                asciiCode = Escape(c1.parse(argument))
            } else if (string.startsWith("""\e""")) {
                asciiCode = Escape(EscapeParameter.parse(string.drop(2)))
            }

            if (asciiCode == null) throw IllegalArgumentException("Doesn't match any ascii control character")

            return asciiCode
        }
    }
    abstract val asciiControlCharacter: AsciiControlCharacter
    abstract fun build(): String
}
