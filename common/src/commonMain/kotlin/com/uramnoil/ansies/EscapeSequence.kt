package com.uramnoil.ansies

sealed class EscapeSequence : Sequence() {
    override val control: Control = Control.Escape
}