package com.uramnoil.ansies

val reset = EscapeSequence(ControlSequenceIntroducer(SelectGraphicRendition(ResetOrNormal)))

class AnsiEscapeBuilder(val string: String, private val canOverrideForegroundColor: Boolean = false) {
    private var foregroundColor: ForegroundColor? = null
    private var backgroundColor: BackgroundColor? = null
    private var blink: Blink? = null

    val escaped: String
        get() = EscapeSequence(
            ControlSequenceIntroducer(
                SelectGraphicRendition(
                    mutableSetOf(
                        foregroundColor,
                        backgroundColor,
                        blink
                    ).filterNotNull().toSet()
                )
            )
        ).build()

    fun black(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorBlack }

    fun red(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorRed }

    fun green(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorGreen }

    fun yellow(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorYellow }

    fun blue(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorBlue }

    fun magenta(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorMagenta }

    fun cyan(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorCyan }

    fun white(): AnsiEscapeBuilder = apply { foregroundColor = SetForegroundColorWhite }

    fun colorPalette(color: UByte): AnsiEscapeBuilder =
        apply { foregroundColor = SetForegroundColorWith(ColorPaletteParameter(color)) }

    fun rgb(red: UByte, green: UByte, blue: UByte): AnsiEscapeBuilder =
        apply { foregroundColor = SetForegroundColorWith(RgbParameter(red, green, blue)) }

    fun build(): String = escaped + reset.build()
}

operator fun AnsiEscapeBuilder.plus(builder: AnsiEscapeBuilder) = listOf(this, builder)

operator fun List<AnsiEscapeBuilder>.plus(builder: AnsiEscapeBuilder): List<AnsiEscapeBuilder> =
    toMutableList().apply { add(builder) }

fun List<AnsiEscapeBuilder>.build(): String = joinToString("") { it.escaped } + reset.build()

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

