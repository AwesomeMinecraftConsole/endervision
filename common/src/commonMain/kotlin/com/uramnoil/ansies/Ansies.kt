package com.uramnoil.ansies

val reset = ResetOrNormal()

val black = SelectGraphicRendition(SetForegroundColorBlack())
val red = SelectGraphicRendition(SetForegroundColorRed())
val green = SelectGraphicRendition(SetForegroundColorGreen())
val yellow = SelectGraphicRendition(SetForegroundColorYellow())
val blue = SelectGraphicRendition(SetForegroundColorBlue())
val magenta = SelectGraphicRendition(SetForegroundColorMagenta())
val cyan = SelectGraphicRendition(SetForegroundColorCyan())
val white = SelectGraphicRendition(SetForegroundColorWhite())

class AnsiEscapeBuilder(val string: String) {
    private val mutableCodeList = mutableListOf<EscapeSequence>()

    internal fun add(sequence: EscapeSequence) {
        mutableCodeList.add(sequence)
    }

    fun black(): AnsiEscapeBuilder = apply { add(black) }

    fun red(): AnsiEscapeBuilder = apply { add(red) }

    fun green(): AnsiEscapeBuilder = apply { add(green) }

    fun yellow(): AnsiEscapeBuilder = apply { add(yellow) }

    fun blue(): AnsiEscapeBuilder = apply { add(blue) }

    fun magenta(): AnsiEscapeBuilder = apply { add(magenta) }

    fun cyan(): AnsiEscapeBuilder = apply { add(cyan) }

    fun white(): AnsiEscapeBuilder = apply { add(white) }

    fun colorPalette(color: UByte): AnsiEscapeBuilder =
        apply { add(SelectGraphicRendition(SetForegroundColor(ColorPaletteParameter(color)))) }

    fun rgb(red: UByte, green: UByte, blue: UByte): AnsiEscapeBuilder =
        apply { add(SelectGraphicRendition(SetForegroundColor(RgbParameter(red, green, blue)))) }

    override fun toString(): String = mutableCodeList.joinToString("") + string
}

fun String.black(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).black()

fun String.red(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).red()

fun String.green(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).green()

fun String.yellow(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).yellow()

fun String.blue(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).blue()

fun String.magenta(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).magenta()

fun String.cyan(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).cyan()

fun String.white(): AnsiEscapeBuilder = AnsiEscapeBuilder(this).white()

fun String.colorPalette(color: UByte): AnsiEscapeBuilder = AnsiEscapeBuilder(this).colorPalette(color)

fun String.rgb(red: UByte, green: UByte, blue: UByte): AnsiEscapeBuilder = AnsiEscapeBuilder(this).rgb(red, green, blue)