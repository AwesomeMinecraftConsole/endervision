package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

operator fun SelectGraphicRenditionParameter.plus(previous: SelectGraphicRenditionParameter) =
    previous.asSequence().basedOn(this.asSequence())

operator fun SelectGraphicRenditionParameter.plus(previous: SelectGraphicRendition) =
    previous.basedOn(this.asSequence())

operator fun SelectGraphicRendition.plus(previous: SelectGraphicRenditionParameter) =
    previous.asSequence().basedOn(this)

operator fun SelectGraphicRendition.plus(previous: SelectGraphicRendition) = previous.basedOn(this)

fun ansiOf(parameter: SelectGraphicRenditionParameter) = ansiOf(parameter.asSequence())

fun ansiOf(sgr: SelectGraphicRendition) =
    Escape(
        ControlSequenceIntroducer(
            sgr
        )
    )