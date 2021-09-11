package com.uramnoil.ansies

enum class EscapeSequenceParameterType(val abbr: String, val gl: Int, val c1: Int) {
    PaddingCharacter("PAD", 64, 128),
    HighOctetPreset("HOP", 65, 129),
    BreakPermittedHere("BPH", 66, 130),
    NoBreakHere("NBH", 67, 131),
    Index("IND", 68, 132),
    NExtLine("NEL", 69, 133),
    StartOfSelectedArea("SSA", 70, 134),
    EndOfSelectedArea("ESA", 71, 135),
    HorizontalTabulationSet("HTS", 72, 136),
    HorizontalTabulationWithJustification("HTJ", 73, 137),
    VerticalTabulationSet("VTS", 74, 138),
    PartialLineDown("PLD", 75, 139),
    PartialLineUp("PLU", 76, 140),
    ReverseIndex("RI", 77, 141),
    SingleShift2("SS2", 78, 142),
    SingleShift3("SS3", 79, 143),
    DeviceControlString("DCS", 80, 144),
    PrivateUse1("PU1", 81, 145),
    PrivateUse2("PU2", 82, 146),
    SetTransmitState("STS", 83, 147),
    CancelCharacter("CCH", 84, 148),
    MessageWaiting("MW", 85, 149),
    StartOfProtectedArea("SPA", 86, 150),
    EndOfProtectedArea("EPA", 87, 151),
    StartOfString("SOS", 88, 152),
    SingleGraphicCharacterIntroducer("SGCI", 89, 153),
    SingleCharacterIntroducer("SCI", 90, 154),
    ControlSequenceIntroducer("CSI", 91, 155),
    StringTerminator("ST", 92, 156),
    OperatingSystemCommand("OSC", 93, 157),
    PrivacyMessage("PM", 94, 158),
    ApplicationProgramCommand("APC", 95, 159), ;

    override fun toString(): String = Char(c1).toString()
}

class EscapeSequence(val parameter: EscapeSequenceParameter) {
    val controlCharacter: ControlCharacter = ControlCharacter.Escape
    fun build() = controlCharacter.toString() + parameter.build()
}

sealed class EscapeSequenceParameter {
    abstract val type: EscapeSequenceParameterType
    abstract fun build(): String
}
