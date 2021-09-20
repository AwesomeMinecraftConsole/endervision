package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.BlackForeground
import com.uramnoil.ansies.parameter.SelectForegroundColor
import com.uramnoil.ansies.parameter.SelectForegroundColorRgb
import com.uramnoil.ansies.parse.ansi
import com.uramnoil.ansies.parse.findAnsiSequences
import com.uramnoil.ansies.parse.removeAnsiSequence
import kotlin.test.Test
import kotlin.test.assertEquals

class ParseTest {
    @Test
    fun testRemoveAnsi() {
        assertEquals(
            "hoge",
            removeAnsiSequence(
                (ansiOf(
                    BlackForeground + SelectForegroundColorRgb(
                        0u,
                        0u,
                        0u
                    )
                ) + "hoge" + reset).build()
            )
        )
    }

    @Test
    fun testRawAndi() {
        assertEquals(
            (ansiOf(BlackForeground) + "," + reset).build(),
            findAnsiSequences((ansiOf(BlackForeground) + "hoge" + reset).build()).joinToString(",")
        )
    }

    @Test
    fun testParseAnsi() {
        assertEquals(
            sgr("30") + "hoge" + reset.build(),
            (ansiOf(BlackForeground) + "hoge" + reset).build().ansi().build()
        )
    }

    @Test
    fun testParseColorRgb() {
        assertEquals(
            sgr("38;2;0;0;0") + reset.build(),
            ansiOf(SelectForegroundColorRgb(0u, 0u, 0u)).build().ansi().build() + reset.build()
        )
    }

    @Test
    fun testParseColorIndexed() {
        assertEquals(
            sgr("38;5;0") + reset.build(),
            ansiOf(SelectForegroundColor(0u)).build().ansi().build() + reset.build()
        )
    }
}