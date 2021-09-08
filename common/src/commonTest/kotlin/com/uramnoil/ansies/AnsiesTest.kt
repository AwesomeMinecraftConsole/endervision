package com.uramnoil.ansies

import kotlin.test.Test
import kotlin.test.assertEquals


class AnsiesTest {
    companion object {
        val csi = "${Char(0x1B)}["
    }

    @Test
    fun testBlack() {
        assertEquals(
            "${csi}30m",
            "".black().toString()
        )
    }

    @Test
    fun testRed() {
        assertEquals(
            "${csi}31m",
            "".red().toString()
        )
    }

    @Test
    fun testGreen() {
        assertEquals(
            "${csi}32m",
            "".green().toString()
        )
    }

    @Test
    fun testYellow() {
        assertEquals(
            "${csi}33m",
            "".yellow().toString()
        )
    }

    @Test
    fun testBlue() {
        assertEquals(
            "${csi}34m",
            "".blue().toString()
        )
    }

    @Test
    fun testMagenta() {
        assertEquals(
            "${csi}35m",
            "".magenta().toString()
        )
    }

    @Test
    fun testCyan() {
        assertEquals(
            "${csi}36m",
            "".cyan().toString()
        )
    }

    @Test
    fun testWhite() {
        assertEquals(
            "${csi}37m",
            "".white().toString()
        )
    }

    @Test
    fun testColorPalette() {
        assertEquals(
            "${csi}38;5;0m",
            "".colorPalette(0u).toString()
        )
    }

    @Test
    fun testRgb() {
        assertEquals("${csi}38;2;0;100;200m",
            "".rgb(0u, 100u, 200u).toString()
        )
    }
}