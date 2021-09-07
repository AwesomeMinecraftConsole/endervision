package com.uramnoil.ansies

enum class Control(val abbr: String, val c0: Int) {
    /**
     * Bell
     * Makes an audible noise.
     */
    Bell("BEL", 0x07),

    /**
     * Backspace
     * Moves the cursor left (but may "backwards wrap" if cursor is at start of line).
     */
    Backspace("BS", 0x08),

    /**
     * Tab
     * Moves the cursor right to next multiple of 8.
     */
    Tab("HT", 0x09),

    /**
     * Line Feed
     * Moves to next line, scrolls the display up if at bottom of the screen.
     * Usually does not move horizontally, though programs should not rely on this.
     */
    LineFeed("LF", 0x0A),

    /**
     *
     */
    VT("VT", 0x0B),

    /**
     * Form Feed
     * Move a printer to top of next page.
     * Usually does not move horizontally, though programs should not rely on this.
     * Effect on video terminals varies.
     */
    FormFeed("FF", 0x0C),

    /**
     * Carriage Return
     * Moves the cursor to column zero.
     */
    CarriageReturn("CR", 0x0D),

    /**
     * Escape
     * Starts all the escape sequences.
     */
    Escape("ESC", 0x1B),

    /**
     *
     */
    DEL("DEL", 0x7F),;

    override fun toString(): String = Char(c0).toString()
}

sealed class Sequence {
    abstract val control: Control
    abstract override fun toString(): String
}