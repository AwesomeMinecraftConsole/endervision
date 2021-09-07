package com.uramnoil.ansies

enum class ControlCharacter(val abbr: String, val c0: Int) {
    Null("Nul", 0x00),
    Bell("BEL", 0x07),
    Backspace("BS", 0x08),
    HorizontalTab("HT", 0x09),
    LineFeed("LF", 0x0A),
    VerticalTab("VT", 0x0B),
    FormFeed("FF", 0x0C),
    CarriageReturn("CR", 0x0D),
    ControlZ("SUB", 0x1A),
    Escape("ESC", 0x1B),
    DEL("DEL", 0x7F), ;
    override fun toString(): String = Char(c0).toString()
}

sealed class Control {
    abstract val controlCharacter: ControlCharacter
    abstract override fun toString(): String
}