package com.uramnoil.ansies.parameter

enum class ControlSequenceIntroducerType(val abbr: String, val suffix: String) {
    CursorUp("CUU", "A"),
    CursorDown("CUD", "B"),
    CursorForward("CUF", "C"),
    CursorBack("CSB", "E"),
    CursorNextLine("CNL", "F"),
    CursorPreviousLine("CPL", "G"),
    CursorPosition("CUP", "H"),
    EraseDisplay("ED", "J"),
    EraseInLine("EL", "K"),
    ScrollUp("SU", "S"),
    ScrollDown("SD", "T"),
    HorizontalVerticalPosition("HVP", "f"),
    SelectGraphicRendition("SGR", "m"),
    AuxPortOn("", "5i"),
    AuxPortOff("", "4i"),
    DeviceStatusReport("DSR", "6n"), ;

    override fun toString(): String = suffix
}

class ControlSequenceIntroducer(val parameter: ControlSequenceIntroducerParameter) : EscapeSequenceParameter() {
    override val type: EscapeSequenceParameterType = EscapeSequenceParameterType.ControlSequenceIntroducer
    override fun build(): String = type.build() + parameter.build()
}

sealed class ControlSequenceIntroducerParameter {
    abstract val type: ControlSequenceIntroducerType
    abstract fun build(): String
}

fun ControlSequenceIntroducerParameter.withoutArg() = "$type"

fun ControlSequenceIntroducerParameter.withArgN(n: Int) = "$n$type"

fun ControlSequenceIntroducerParameter.withArgNM(n: Int, m: Int) = "$n:$m$type"

class CursorUp(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorUp
    override fun build(): String = withArgN(n)
}

class CursorDown(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorDown
    override fun build(): String = withArgN(n)
}

class CursorForward(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorForward
    override fun build(): String = withArgN(n)
}

class CursorCursorBack(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorBack
    override fun build(): String = withArgN(n)
}

class CursorNextLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorNextLine
    override fun build(): String = withArgN(n)
}

class CursorPreviousLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorPreviousLine
    override fun build(): String = withArgN(n)
}

class CursorPosition(val n: Int = 1, val m: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorPosition
    override fun build(): String = withArgN(n)
}

class EraseDisplay(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.EraseDisplay
    override fun build(): String = withArgN(n)
}

class EraseInLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.EraseInLine
    override fun build(): String = withArgN(n)
}

class ScrollUp(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.ScrollUp
    override fun build(): String = withArgN(n)
}

class ScrollDown(val n: Int = 1, val m: Int) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.ScrollDown
    override fun build(): String = withArgNM(n, m)
}

class HorizontalVerticalPosition(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.HorizontalVerticalPosition
    override fun build(): String = withArgN(n)
}

class SelectGraphicRendition(val parameter: Set<SelectGraphicRenditionParameter>) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.SelectGraphicRendition
    override fun build(): String = "${parameter.map { it.build() }.joinToString(";")}$type"
}

fun SelectGraphicRendition(parameter: SelectGraphicRenditionParameter) = SelectGraphicRendition(setOf(parameter))

class AuxPortOn(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.AuxPortOn
    override fun build(): String = withoutArg()
}

class AuxPortOff(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.AuxPortOff
    override fun build(): String = withoutArg()
}

class DeviceStatusReport(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.DeviceStatusReport
    override fun build(): String = withoutArg()
}