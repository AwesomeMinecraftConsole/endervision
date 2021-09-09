package com.uramnoil.ansies

val reset = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(ResetOrNormal())))

val black = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorBlack())))
val red = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorRed())))
val green = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorGreen())))
val yellow = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorYellow())))
val blue = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorBlue())))
val magenta = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorMagenta())))
val cyan = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorCyan())))
val white = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColorWhite())))

class AnsiEscapeBuilder(val string: String) {
    private val mutableCodeList = mutableListOf<EscapeSequence>()
    val escaped: String
        get() = mutableCodeList.map { it.build() }.joinToString("") + string

    internal fun add(escapeSequence: EscapeSequence) {
        mutableCodeList.add(escapeSequence)
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
        apply { add(EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColor(ColorPaletteParameter(color)))))) }

    fun rgb(red: UByte, green: UByte, blue: UByte): AnsiEscapeBuilder =
        apply { add(EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(SetForegroundColor(RgbParameter(red, green, blue)))))) }

    fun build(): String = escaped + reset.build()
}

operator fun AnsiEscapeBuilder.plus(builder: AnsiEscapeBuilder) = listOf(this, builder)

operator fun AnsiEscapeBuilder.plus(escapeSequence: EscapeSequence) = listOf(this, AnsiEscapeBuilder("").add(escapeSequence))

operator fun List<AnsiEscapeBuilder>.plus(builder: AnsiEscapeBuilder): List<AnsiEscapeBuilder> = apply { toMutableList().add(builder) }

operator fun List<AnsiEscapeBuilder>.plus(escapeSequence: EscapeSequence) = listOf(this, AnsiEscapeBuilder("").add(escapeSequence))

fun List<AnsiEscapeBuilder>.build(): String = map { it.escaped }.joinToString("") + reset.build()

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