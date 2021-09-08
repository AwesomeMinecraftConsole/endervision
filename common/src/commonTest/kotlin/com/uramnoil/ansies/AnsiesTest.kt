package com.uramnoil.ansies

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class AnsiesTest {
    @Test
    fun testBlack() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}30m",
            "".black().toString()
        )
    }

    @Test
    fun testRed() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}31m",
            "".red().toString()
        )
    }

    @Test
    fun testGreen() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}32m",
            "".green().toString()
        )
    }

    @Test
    fun testYellow() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}33m",
            "".yellow().toString()
        )
    }

    @Test
    fun testBlue() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}34m",
            "".blue().toString()
        )
    }

    @Test
    fun testMagenta() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}35m",
            "".magenta().toString()
        )
    }

    @Test
    fun testCyan() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}36m",
            "".cyan().toString()
        )
    }

    @Test
    fun testWhite() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}37m",
            "".white().toString()
        )
    }

    @Test
    fun testColor8() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}38;5;0m",
            "".colorPalette(0u).toString()
        )
    }

    @Test
    fun testRgb() {
        assertEquals("${Char(0x1B)}${Char(0x9B)}38;2;0;100;200m",
            "".rgb(0u, 100u, 200u).toString()
        )
    }
}