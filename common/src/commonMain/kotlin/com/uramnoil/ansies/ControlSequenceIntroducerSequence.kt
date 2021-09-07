package com.uramnoil.ansies

enum class ControlSequenceIntroducer(val abbr: String, val c2: String) {
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

    override fun toString(): String = c2
}

typealias Csi = ControlSequenceIntroducer

sealed class ControlSequenceIntroducerSequence : EscapeSequence() {
    override val type: EscapeSequenceType = EscapeSequenceType.ControlSequenceIntroducer
    abstract val csi: Csi
}

fun ControlSequenceIntroducerSequence.withoutArg() = "$controlCharacter$type$csi"

fun ControlSequenceIntroducerSequence.withArgN(n: Int) = "$controlCharacter$type$n$csi"

fun ControlSequenceIntroducerSequence.withArgNM(n: Int, m: Int) = "$controlCharacter$type$n:$m$csi"

class CursorUp(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorUp
    override fun toString(): String = withArgN(n)
}

class CursorDown(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorDown
    override fun toString(): String = withArgN(n)
}

class CursorForward(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorForward
    override fun toString(): String = withArgN(n)
}

class CursorCursorBack(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorBack
    override fun toString(): String = withArgN(n)
}

class CursorNextLine(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorNextLine
    override fun toString(): String = withArgN(n)
}

class CursorPreviousLine(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorPreviousLine
    override fun toString(): String = withArgN(n)
}

class CursorPosition(val n: Int = 1, val m: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.CursorPosition
    override fun toString(): String = withArgN(n)
}

class EraseDisplay(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.EraseDisplay
    override fun toString(): String = withArgN(n)
}

class EraseInLine(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.EraseInLine
    override fun toString(): String = withArgN(n)
}

class ScrollUp(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.ScrollUp
    override fun toString(): String = withArgN(n)
}

class ScrollDown(val n: Int = 1, val m: Int) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.ScrollDown
    override fun toString(): String = withArgNM(n, m)
}

class HorizontalVerticalPosition(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.HorizontalVerticalPosition
    override fun toString(): String = withArgN(n)
}

class SelectGraphicRendition(val parameter: SelectGraphicRenditionParameter) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.SelectGraphicRendition
    override fun toString(): String = "$controlCharacter$type$parameter$csi"
}

class AuxPortOn(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.AuxPortOn
    override fun toString(): String = withoutArg()
}

class AuxPortOff(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.AuxPortOff
    override fun toString(): String = withoutArg()
}

class DeviceStatusReport(val n: Int = 1) : ControlSequenceIntroducerSequence() {
    override val csi: Csi = Csi.DeviceStatusReport
    override fun toString(): String = withoutArg()
}