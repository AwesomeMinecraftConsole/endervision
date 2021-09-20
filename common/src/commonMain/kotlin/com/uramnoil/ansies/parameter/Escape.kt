package com.uramnoil.ansies.parameter

enum class EscapeParameters(val abbr: String, val gl: Int, val c1: Int) {
    PaddingCharacter("PAD", 64, 128) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    HighOctetPreset("HOP", 65, 129) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    BreakPermittedHere("BPH", 66, 130) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    NoBreakHere("NBH", 67, 131) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    Index("IND", 68, 132) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    NExtLine("NEL", 69, 133) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    StartOfSelectedArea("SSA", 70, 134) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    EndOfSelectedArea("ESA", 71, 135) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    HorizontalTabulationSet("HTS", 72, 136) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    HorizontalTabulationWithJustification("HTJ", 73, 137) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    VerticalTabulationSet("VTS", 74, 138) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    PartialLineDown("PLD", 75, 139) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    PartialLineUp("PLU", 76, 140) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    ReverseIndex("RI", 77, 141) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    SingleShift2("SS2", 78, 142) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    SingleShift3("SS3", 79, 143) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    DeviceControlString("DCS", 80, 144) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    PrivateUse1("PU1", 81, 145) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    PrivateUse2("PU2", 82, 146) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    SetTransmitState("STS", 83, 147) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    CancelCharacter("CCH", 84, 148) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    MessageWaiting("MW", 85, 149) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    StartOfProtectedArea("SPA", 86, 150) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    EndOfProtectedArea("EPA", 87, 151) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    StartOfString("SOS", 88, 152) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    SingleGraphicCharacterIntroducer("SGCI", 89, 153) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    SingleCharacterIntroducer("SCI", 90, 154) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    ControlSequenceIntroducer("CSI", 91, 155) {
        override fun parse(argument: String): EscapeParameter {
            return ControlSequenceIntroducer(ControlSequenceIntroducerParameter.parse(argument))
        }
    },
    StringTerminator("ST", 92, 156) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    OperatingSystemCommand("OSC", 93, 157) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    PrivacyMessage("PM", 94, 158) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    },
    ApplicationProgramCommand("APC", 95, 159) {
        override fun parse(argument: String): EscapeParameter {
            TODO("Not yet implemented")
        }
    }, ;

    fun build(): String = Char(gl).toString()
    abstract fun parse(argument: String): EscapeParameter
}

class Escape(val parameter: EscapeParameter) : AsciiControlCharacter() {
    override val asciiControlCharacterType: AsciiControlCharacterType = AsciiControlCharacterType.Escape
    override fun build() = asciiControlCharacterType.build() + parameter.build()
}

sealed class EscapeParameter {
    companion object {
        private val map = EscapeParameters.values().associateBy { Char(it.gl) }

        fun parse(string: String): EscapeParameter {
            val type = string.first()
            val argument = string.drop(1)
            return map[type]?.parse(argument) ?: throw IllegalArgumentException("doesn't match any parameter")
        }
    }

    abstract val type: EscapeParameters
    abstract fun build(): String
}
