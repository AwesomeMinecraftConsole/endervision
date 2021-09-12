package com.uramnoil.ansies

enum class SelectGraphicRenditionParameterType(val m: Int) {
    ResetOrNormal(0),
    BoldOrIncreasedIntensity(1),
    FaintDecreasedIntensityOrDim(2),
    Italic(3),
    Underline(4),
    SlowBlink(5),
    RapidBlink(6),
    ReverseVideoOrInvert(7),
    ConcealOrHide(8),
    CrossedOutOrStrike(9),
    PrimaryFont(10),
    AlternativeFont1(11),
    AlternativeFont2(12),
    AlternativeFont3(13),
    AlternativeFont4(14),
    AlternativeFont5(15),
    AlternativeFont6(16),
    AlternativeFont7(17),
    AlternativeFont8(18),
    AlternativeFont9(19),
    BlackletterFont(20),
    DoublyUnderlinedOrNotBold(21),
    NormalIntensity(22),
    NeitherItalicNorBlackletter(23),
    NotUnderlined(24),
    NotBlinking(25),
    ProportionalSpacing(26),
    NotReversed(27),
    Reveal(28),
    NotCrossedOut(29),
    SetForegroundColorBlack(30),
    SetForegroundColorRed(31),
    SetForegroundColorGreen(32),
    SetForegroundColorYellow(33),
    SetForegroundColorBlue(34),
    SetForegroundColorMagenta(35),
    SetForegroundColorCyan(36),
    SetForegroundColorWhite(37),
    SetForegroundColor(38),
    DefaultForegroundColor(39),
    SetBackgroundColorBlack(40),
    SetBackgroundColorRed(41),
    SetBackgroundColorGreen(42),
    SetBackgroundColorYellow(43),
    SetBackgroundColorBlue(44),
    SetBackgroundColorMagenta(45),
    SetBackgroundColorCyan(46),
    SetBackgroundColorWhite(47),
    SetBackgroundColor(48),
    DefaultBackgroundColor(49),
    DisableProportionalSpacing(50),
    Framed(51),
    Encircled(52),
    Overlined(53),
    NeitherFramedNorEncircled(54),
    NotOverlined(55),
    SetUnderlineColor(58),
    DefaultUnderlineColor(59),
    IdeogramUnderlineOrRightSideLine(60),
    IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide(61),
    IdeogramOverlineOrLeftSideLine(62),
    IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide(63),
    IdeogramStressMarking(64),
    NoIdeogramAttributes(65),
    Superscript(73),
    Subscript(74),
    NeitherSuperscriptNorSubscript(75),
    SetBrightForegroundColorBlack(90),
    SetBrightForegroundColorRed(91),
    SetBrightForegroundColorGreen(92),
    SetBrightForegroundColorYellow(93),
    SetBrightForegroundColorBlue(94),
    SetBrightForegroundColorMagenta(95),
    SetBrightForegroundColorCyan(96),
    SetBrightForegroundColorWhite(97),
    SetBrightBackgroundColorBlack(100),
    SetBrightBackgroundColorRed(101),
    SetBrightBackgroundColorGreen(102),
    SetBrightBackgroundColorYellow(103),
    SetBrightBackgroundColorBlue(104),
    SetBrightBackgroundColorMagenta(105),
    SetBrightBackgroundColorCyan(106),
    SetBrightBackgroundColorWhite(107), ;

    override fun toString(): String = m.toString()
}

sealed class SelectGraphicRenditionParameter {
    abstract val type: SelectGraphicRenditionParameterType
    abstract fun build(): String
    abstract fun asBuilder(): SelectGraphicRenditionSequenceBuilder
}

fun SelectGraphicRenditionParameter.withoutArg() = type.toString()

object ResetOrNormal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ResetOrNormal
    override fun build(): String = withoutArg()
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(startWithReset = this)
}

sealed class Intensity : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(intensity = this)
}

object BoldOrIncreasedIntensity : Intensity() {
    override val type = SelectGraphicRenditionParameterType.BoldOrIncreasedIntensity
    override fun build(): String = withoutArg()
}

object FaintDecreasedIntensityOrDim : Intensity() {
    override val type = SelectGraphicRenditionParameterType.FaintDecreasedIntensityOrDim
    override fun build(): String = withoutArg()
}

sealed class Font : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(font = this)
}

object Italic : Font() {
    override val type = SelectGraphicRenditionParameterType.Italic
    override fun build(): String = withoutArg()
}

sealed class Underline : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(underline = this)
}

object Underlined : Underline() {
    override val type = SelectGraphicRenditionParameterType.Underline
    override fun build(): String = withoutArg()
}

sealed class Blink : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(blink = this)
}

object SlowBlink : Blink() {
    override val type = SelectGraphicRenditionParameterType.SlowBlink
    override fun build(): String = withoutArg()
}

object RapidBlink : Blink() {
    override val type = SelectGraphicRenditionParameterType.RapidBlink
    override fun build(): String = withoutArg()
}

sealed class Reverse : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(reverse = this)
}

object Reversed : Reverse() {
    override val type = SelectGraphicRenditionParameterType.ReverseVideoOrInvert
    override fun build(): String = withoutArg()
}

sealed class Conceal : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(conceal = this)
}

object Concealed : Conceal() {
    override val type = SelectGraphicRenditionParameterType.ConcealOrHide
    override fun build(): String = withoutArg()
}

sealed class Strikethrough : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(crossedOut = this)
}

object CrossedOut : Strikethrough() {
    override val type = SelectGraphicRenditionParameterType.CrossedOutOrStrike
    override fun build(): String = withoutArg()
}

object PrimaryFont : Font() {
    override val type = SelectGraphicRenditionParameterType.PrimaryFont
    override fun build(): String = withoutArg()
}

object AlternativeFont1 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont1
    override fun build(): String = withoutArg()
}

object AlternativeFont2 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont2
    override fun build(): String = withoutArg()
}

object AlternativeFont3 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont3
    override fun build(): String = withoutArg()
}

object AlternativeFont4 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont4
    override fun build(): String = withoutArg()
}

object AlternativeFont5 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont5
    override fun build(): String = withoutArg()
}

object AlternativeFont6 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont6
    override fun build(): String = withoutArg()
}

object AlternativeFont7 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont7
    override fun build(): String = withoutArg()
}

object AlternativeFont8 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont8
    override fun build(): String = withoutArg()
}

object AlternativeFont9 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont9
    override fun build(): String = withoutArg()
}

object BlackletterFont : Font() {
    override val type = SelectGraphicRenditionParameterType.BlackletterFont
    override fun build(): String = withoutArg()
}

object DoublyUnderlinedOrNotBold : Underline() {
    override val type = SelectGraphicRenditionParameterType.DoublyUnderlinedOrNotBold
    override fun build(): String = withoutArg()
}

object NormalIntensity : Intensity() {
    override val type = SelectGraphicRenditionParameterType.NormalIntensity
    override fun build(): String = withoutArg()
}

object NeitherItalicNorBlackletter : Font() {
    override val type = SelectGraphicRenditionParameterType.NeitherItalicNorBlackletter
    override fun build(): String = withoutArg()
}

object NotUnderlined : Underline() {
    override val type = SelectGraphicRenditionParameterType.NotUnderlined
    override fun build(): String = withoutArg()
}

object NotBlinking : Blink() {
    override val type = SelectGraphicRenditionParameterType.NotBlinking
    override fun build(): String = withoutArg()
}

object ProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ProportionalSpacing
    override fun build(): String = withoutArg()
    override fun asBuilder(): SelectGraphicRenditionSequenceBuilder {
        TODO("Not yet implemented")
    }
}

object NotReversed : Reverse() {
    override val type = SelectGraphicRenditionParameterType.NotReversed
    override fun build(): String = withoutArg()
}

object Reveal : Conceal() {
    override val type = SelectGraphicRenditionParameterType.Reveal
    override fun build(): String = withoutArg()
}

object NotCrossedOut : Strikethrough() {
    override val type = SelectGraphicRenditionParameterType.NotCrossedOut
    override fun build(): String = withoutArg()
}

sealed class ForegroundColor : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(foregroundColor = this)
}

object SetForegroundColorBlack : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorBlack
    override fun build(): String = withoutArg()
}

object SetForegroundColorRed : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorRed
    override fun build(): String = withoutArg()
}

object SetForegroundColorGreen : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorGreen
    override fun build(): String = withoutArg()
}

object SetForegroundColorYellow : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorYellow
    override fun build(): String = withoutArg()
}

object SetForegroundColorBlue : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorBlue
    override fun build(): String = withoutArg()
}

object SetForegroundColorMagenta : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorMagenta
    override fun build(): String = withoutArg()
}

object SetForegroundColorCyan : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorCyan
    override fun build(): String = withoutArg()
}

object SetForegroundColorWhite : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorWhite
    override fun build(): String = withoutArg()
}

class SetForegroundColorWith(val parameter: ColorParameter) : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColor
    override fun build(): String = "$type;${parameter.build()}"
}

object DefaultForegroundColor : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.DefaultForegroundColor
    override fun build(): String = withoutArg()
}

sealed class BackgroundColor : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(backgroundColor = this)
}

object SetBackgroundColorBlack : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorBlack
    override fun build(): String = withoutArg()
}

object SetBackgroundColorRed : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorRed
    override fun build(): String = withoutArg()
}

object SetBackgroundColorGreen : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorGreen
    override fun build(): String = withoutArg()
}

object SetBackgroundColorYellow : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorYellow
    override fun build(): String = withoutArg()
}

object SetBackgroundColorBlue : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorBlue
    override fun build(): String = withoutArg()
}

object SetBackgroundColorMagenta : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorMagenta
    override fun build(): String = withoutArg()
}

object SetBackgroundColorCyan : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorCyan
    override fun build(): String = withoutArg()
}

object SetBackgroundColorWhite : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorWhite
    override fun build(): String = withoutArg()
}

class SetBackgroundColorWith(val parameter: ColorParameter) : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColor
    override fun build(): String = "$type;${parameter.build()}"
}

object DefaultBackgroundColor : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.DefaultBackgroundColor
    override fun build(): String = withoutArg()
}

object DisableProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DisableProportionalSpacing
    override fun build(): String = withoutArg()
    override fun asBuilder(): SelectGraphicRenditionSequenceBuilder {
        TODO("Not yet implemented")
    }
}

sealed class EmojiVariationSelector : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(emojiVariation = this)
}

object Framed :EmojiVariationSelector() {
    override val type = SelectGraphicRenditionParameterType.Framed
    override fun build(): String = withoutArg()
}

object Encircled : EmojiVariationSelector() {
    override val type = SelectGraphicRenditionParameterType.Encircled
    override fun build(): String = withoutArg()
}

sealed class Overline : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(overline = this)
}

object Overlined : Overline() {
    override val type = SelectGraphicRenditionParameterType.Overlined
    override fun build(): String = withoutArg()
}

object NeitherFramedNorEncircled : EmojiVariationSelector() {
    override val type = SelectGraphicRenditionParameterType.NeitherFramedNorEncircled
    override fun build(): String = withoutArg()
}

object NotOverlined : Overline() {
    override val type = SelectGraphicRenditionParameterType.NotOverlined
    override fun build(): String = withoutArg()
}

sealed class UnderLineColor : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(underlineColor = this)
}

class SetUnderlineColor(val parameter: ColorPaletteParameter) : UnderLineColor() {
    override val type = SelectGraphicRenditionParameterType.SetUnderlineColor
    override fun build(): String = type.toString() + parameter.build()
}

object DefaultUnderlineColor : UnderLineColor() {
    override val type = SelectGraphicRenditionParameterType.DefaultUnderlineColor
    override fun build(): String = withoutArg()
}

sealed class Ideogram : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(ideogram = this)
}

object IdeogramUnderlineOrRightSideLine : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramUnderlineOrRightSideLine
    override fun build(): String = withoutArg()
}

object IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide
    override fun build(): String = withoutArg()
}

object IdeogramOverlineOrLeftSideLine : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramOverlineOrLeftSideLine
    override fun build(): String = withoutArg()
}

object IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide
    override fun build(): String = withoutArg()
}

object IdeogramStressMarking : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramStressMarking
    override fun build(): String = withoutArg()
}

object NoIdeogramSelectAttributes : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.NoIdeogramAttributes
    override fun build(): String = withoutArg()
}

sealed class Script : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(script = this)
}

object Superscript : Script() {
    override val type = SelectGraphicRenditionParameterType.Superscript
    override fun build(): String = withoutArg()
}

object Subscript : Script() {
    override val type = SelectGraphicRenditionParameterType.Subscript
    override fun build(): String = withoutArg()
}

object NeitherSuperscriptNorSubscript : Script() {
    override val type = SelectGraphicRenditionParameterType.NeitherSuperscriptNorSubscript
    override fun build(): String = withoutArg()
}

sealed class BrightForegroundColor : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(brightForegroundColor = this)
}

object SetBrightForegroundColorBlack : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorBlack
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorRed : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorRed
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorGreen : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorGreen
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorYellow : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorYellow
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorBlue : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorBlue
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorMagenta : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorMagenta
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorCyan : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorCyan
    override fun build(): String = withoutArg()
}

object SetBrightForegroundColorWhite : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorWhite
    override fun build(): String = withoutArg()
}

sealed class BrightBackgroundColor : SelectGraphicRenditionParameter() {
    override fun asBuilder() = SelectGraphicRenditionSequenceBuilder(brightBackgroundColor = this)
}

object SetBrightBackgroundColorBlack : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorBlack
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorRed : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorRed
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorGreen : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorGreen
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorYellow : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorYellow
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorBlue : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorBlue
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorMagenta : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorMagenta
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorCyan : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorCyan
    override fun build(): String = withoutArg()
}

object SetBrightBackgroundColorWhite : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorWhite
    override fun build(): String = withoutArg()
}


enum class ColorMode(val mode: Int) {
    ColorPalette(5),
    Rgb(2), ;

    override fun toString(): String = mode.toString()
}

sealed class ColorParameter {
    abstract val mode: ColorMode
    abstract fun build(): String
}

class ColorPaletteParameter(val color: UByte) : ColorParameter() {
    override val mode = ColorMode.ColorPalette
    override fun build(): String = "$mode;$color"
}

class RgbParameter(val red: UByte, val green: UByte, val blue: UByte) : ColorParameter() {
    override val mode = ColorMode.Rgb
    override fun build(): String = "$mode;$red;$green;$blue"
}