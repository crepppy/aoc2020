package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day01Test {
    private val expenses = listOf(1721, 979, 366, 299, 675, 1456)

    @Test
    fun `test product of two numbers that add to 2020`() {
        assertEquals(514579, find2020SumOfTwo(expenses))
    }

    @Test
    fun `test product of three numbers that add to 2020`() {
        assertEquals(241861950, find2020SumOfThree(expenses))
    }
}