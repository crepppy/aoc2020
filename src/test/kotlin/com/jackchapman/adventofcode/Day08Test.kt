package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day08Test {
    @Test
    fun `test value in accumulator before repeat`() {
        val instructions = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent()

        assertEquals(5, calculateAccBeforeRepeat(instructions.lines()))
    }

    @Test
    fun `test value in accumulator is no repeat`() {
        val instructions = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent()

        assertEquals(8, calculateAccAfterInstructionChange(instructions.lines()))
    }
}