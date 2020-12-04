package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DayTwoTest {
    private val passwordA = "1-3 a: abcde"
    private val passwordB = "1-3 b: cdefg"
    private val passwordC = "2-9 c: ccccccccc"

    @Test
    fun `test password on number of characters`() {
        assertTrue(isValidCount(passwordA))
        assertFalse(isValidCount(passwordB))
        assertTrue(isValidCount(passwordC))
    }

    @Test
    fun `test password on position of characters`() {
        assertTrue(isValidPosition(passwordA))
        assertFalse(isValidPosition(passwordB))
        assertFalse(isValidPosition(passwordC))
    }
}