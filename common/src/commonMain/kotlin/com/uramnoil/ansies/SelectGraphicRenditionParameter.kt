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
    abstract override fun toString(): String
}

fun SelectGraphicRenditionParameter.withoutArg() = type.toString()

object ResetOrNormal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ResetOrNormal
    override fun toString(): String = withoutArg()
}

interface Attribute

object BoldOrIncreasedIntensity : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.BoldOrIncreasedIntensity
    override fun toString(): String = withoutArg()
}

object FaintDecreasedIntensityOrDim : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.FaintDecreasedIntensityOrDim
    override fun toString(): String = withoutArg()
}

object Italic : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.Italic
    override fun toString(): String = withoutArg()
}

object Underline : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.Underline
    override fun toString(): String = withoutArg()
}

sealed class Blink : SelectGraphicRenditionParameter()

object SlowBlink : Blink() {
    override val type = SelectGraphicRenditionParameterType.SlowBlink
    override fun toString(): String = withoutArg()
}

object RapidBlink : Blink() {
    override val type = SelectGraphicRenditionParameterType.RapidBlink
    override fun toString(): String = withoutArg()
}

object ReverseVideoOrInvert : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.ReverseVideoOrInvert
    override fun toString(): String = withoutArg()
}

object ConcealOrHide : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.ConcealOrHide
    override fun toString(): String = withoutArg()
}

object CrossedOutOrStrike : SelectGraphicRenditionParameter(), Attribute {
    override val type = SelectGraphicRenditionParameterType.CrossedOutOrStrike
    override fun toString(): String = withoutArg()
}

sealed class Font : SelectGraphicRenditionParameter()

object PrimaryFont : Font() {
    override val type = SelectGraphicRenditionParameterType.PrimaryFont
    override fun toString(): String = withoutArg()
}

object AlternativeFont1 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont1
    override fun toString(): String = withoutArg()
}

object AlternativeFont2 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont2
    override fun toString(): String = withoutArg()
}

object AlternativeFont3 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont3
    override fun toString(): String = withoutArg()
}

object AlternativeFont4 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont4
    override fun toString(): String = withoutArg()
}

object AlternativeFont5 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont5
    override fun toString(): String = withoutArg()
}

object AlternativeFont6 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont6
    override fun toString(): String = withoutArg()
}

object AlternativeFont7 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont7
    override fun toString(): String = withoutArg()
}

object AlternativeFont8 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont8
    override fun toString(): String = withoutArg()
}

object AlternativeFont9 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont9
    override fun toString(): String = withoutArg()
}

object BlackletterFont : Font() {
    override val type = SelectGraphicRenditionParameterType.BlackletterFont
    override fun toString(): String = withoutArg()
}

object DoublyUnderlinedOrNotBold : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DoublyUnderlinedOrNotBold
    override fun toString(): String = withoutArg()
}

object NormalIntensity : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NormalIntensity
    override fun toString(): String = withoutArg()
}

object NeitherItalicNorBlackletter : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NeitherItalicNorBlackletter
    override fun toString(): String = withoutArg()
}

object NotUnderlined : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotUnderlined
    override fun toString(): String = withoutArg()
}

object NotBlinking : Blink() {
    override val type = SelectGraphicRenditionParameterType.NotBlinking
    override fun toString(): String = withoutArg()
}

object ProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ProportionalSpacing
    override fun toString(): String = withoutArg()
}

object NotReversed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotReversed
    override fun toString(): String = withoutArg()
}

object Reveal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Reveal
    override fun toString(): String = withoutArg()
}

object NotCrossedOut : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotCrossedOut
    override fun toString(): String = withoutArg()
}

sealed class SetForegroundColor : SelectGraphicRenditionParameter()

object SetForegroundColorBlack : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorBlack
    override fun toString(): String = withoutArg()
}

object SetForegroundColorRed : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorRed
    override fun toString(): String = withoutArg()
}

object SetForegroundColorGreen : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorGreen
    override fun toString(): String = withoutArg()
}

object SetForegroundColorYellow : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorYellow
    override fun toString(): String = withoutArg()
}

object SetForegroundColorBlue : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorBlue
    override fun toString(): String = withoutArg()
}

object SetForegroundColorMagenta : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorMagenta
    override fun toString(): String = withoutArg()
}

object SetForegroundColorCyan : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorCyan
    override fun toString(): String = withoutArg()
}

object SetForegroundColorWhite : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorWhite
    override fun toString(): String = withoutArg()
}

class SetForegroundColorWith(val parameter: ColorParameter) : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColor
    override fun toString(): String = "$type;$parameter"
}

object DefaultForegroundColor : SetForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.DefaultForegroundColor
    override fun toString(): String = withoutArg()
}

sealed class SetBackgroundColor : SelectGraphicRenditionParameter() 

object SetBackgroundColorBlack : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorBlack
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorRed : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorRed
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorGreen : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorGreen
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorYellow : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorYellow
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorBlue : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorBlue
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorMagenta : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorMagenta
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorCyan : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorCyan
    override fun toString(): String = withoutArg()
}

object SetBackgroundColorWhite : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorWhite
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorWith(val parameter: ColorParameter) : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColor
    override fun toString(): String = "$type;$parameter"
}

object DefaultBackgroundColor : SetBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.DefaultBackgroundColor
    override fun toString(): String = withoutArg()
}

object DisableProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DisableProportionalSpacing
    override fun toString(): String = withoutArg()
}

object Framed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Framed
    override fun toString(): String = withoutArg()
}

object Encircled : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Encircled
    override fun toString(): String = withoutArg()
}

object Overlined : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Overlined
    override fun toString(): String = withoutArg()
}

object NeitherFramedNorEncircled : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NeitherFramedNorEncircled
    override fun toString(): String = withoutArg()
}

object NotOverlined : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotOverlined
    override fun toString(): String = withoutArg()
}

object SetUnderlineColor : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetUnderlineColor
    override fun toString(): String = withoutArg()
}

object DefaultUnderlineColor : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DefaultUnderlineColor
    override fun toString(): String = withoutArg()
}

object IdeogramUnderlineOrRightSideLine : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramUnderlineOrRightSideLine
    override fun toString(): String = withoutArg()
}

object IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide
    override fun toString(): String = withoutArg()
}

object IdeogramOverlineOrLeftSideLine : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramOverlineOrLeftSideLine
    override fun toString(): String = withoutArg()
}

object IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide
    override fun toString(): String = withoutArg()
}

object IdeogramStressMarking : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramStressMarking
    override fun toString(): String = withoutArg()
}

object NoIdeogramAttributes : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NoIdeogramAttributes
    override fun toString(): String = withoutArg()
}

object Superscript : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Superscript
    override fun toString(): String = withoutArg()
}

object Subscript : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Subscript
    override fun toString(): String = withoutArg()
}

object NeitherSuperscriptNorSubscript : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NeitherSuperscriptNorSubscript
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorBlack : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorBlack
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorRed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorRed
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorGreen : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorGreen
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorYellow : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorYellow
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorBlue : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorBlue
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorMagenta : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorMagenta
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorCyan : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorCyan
    override fun toString(): String = withoutArg()
}

object SetBrightForegroundColorWhite : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorWhite
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorBlack : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorBlack
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorRed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorRed
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorGreen : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorGreen
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorYellow : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorYellow
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorBlue : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorBlue
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorMagenta : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorMagenta
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorCyan : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorCyan
    override fun toString(): String = withoutArg()
}

object SetBrightBackgroundColorWhite : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorWhite
    override fun toString(): String = withoutArg()
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