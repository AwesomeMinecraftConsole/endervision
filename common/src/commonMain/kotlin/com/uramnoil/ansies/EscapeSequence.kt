package com.uramnoil.ansies

enum class EscapeSequenceType(val abbr: String, val c1: Int) {
    SingleShiftTwo("SS2", 0x8E),
    SingleShiftThree("SS3", 0x8F),
    DeviceControlString("DCS", 0x90),
    ControlSequenceIntroducer("CSI", 0x5B),
    StringTerminator("ST", 0x9C),
    OperatingSystemCommand("OSC", 0x9D),
    StartOfString("SOS", 0x98),
    PrivacyMessage("PM", 0x9E),
    ApplicationProgramCommand("APC", 0x9F), ;

    override fun toString(): String = Char(c1).toString()
}

sealed class EscapeSequence : Control() {
    override val controlCharacter: ControlCharacter = ControlCharacter.Escape
    abstract val type: EscapeSequenceType
    abstract override fun toString(): String
}

operator fun EscapeSequence.plus(string: String): String = this.toString() + string