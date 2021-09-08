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
    
    private fun add(sequence: EscapeSequence) {
        mutableCodeList.add(sequence)
    }
    
    fun black(): AnsiEscapeBuilder {
        add(black)
        return this
    }
    
    fun red(): AnsiEscapeBuilder {
        add(red)
        return this
    }
    
    fun green(): AnsiEscapeBuilder {
        add(green)
        return this
    }

    fun yellow(): AnsiEscapeBuilder {
        add(yellow)
        return this
    }

    fun blue(): AnsiEscapeBuilder {
        add(blue)
        return this
    }

    fun magenta(): AnsiEscapeBuilder {
        add(magenta)
        return this
    }

    fun cyan(): AnsiEscapeBuilder {
        add(cyan)
        return this
    }

    fun white(): AnsiEscapeBuilder {
        add(white)
        return this
    }

    fun colorPalette(color: UByte): AnsiEscapeBuilder {
        add(SelectGraphicRendition(SetForegroundColor(ColorPaletteParameter(color))))
        return this
    }

    fun rgb(red: UByte, green: UByte, blue: UByte): AnsiEscapeBuilder {
        add(SelectGraphicRendition(SetForegroundColor(RgbParameter(red, green, blue))))
        return this
    }

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