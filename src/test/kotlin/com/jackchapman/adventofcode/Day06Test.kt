package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day06Test {
    private val questions1 = "abc"

    private val questions2 = """
            a
            b
            c
        """.trimIndent()

    private val questions3 = """
            ab
            ac
        """.trimIndent()

    private val questions4 = """
        a
        a
        a
        a
        """.trimIndent()

    private val questions5 = "b"


    @Test
    fun `test number of questions answered yes`() {
        val questions6 = """
            abcx
            abcy
            abcz
        """.trimIndent()

        assertEquals(3, questionsAnswered(questions1))
        assertEquals(3, questionsAnswered(questions2))
        assertEquals(3, questionsAnswered(questions3))
        assertEquals(1, questionsAnswered(questions4))
        assertEquals(1, questionsAnswered(questions5))
        assertEquals(6, questionsAnswered(questions6))
    }

    @Test
    fun `test number of questions everyone answered yes`() {
        assertEquals(3, questionsEveryoneAnswered(questions1))
        assertEquals(0, questionsEveryoneAnswered(questions2))
        assertEquals(1, questionsEveryoneAnswered(questions3))
        assertEquals(1, questionsEveryoneAnswered(questions4))
        assertEquals(1, questionsEveryoneAnswered(questions5))
    }
}