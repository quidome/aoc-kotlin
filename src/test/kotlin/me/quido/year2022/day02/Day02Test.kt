package me.quido.year2022.day02

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Day02Test {
    private val input = """
        A Y
        B X
        C Z
        """.trimIndent().trimEnd()

    private val solver = Day02(input)

    @Test
    fun givenTestSetMethodShouldReturn15() {
        val expected = 15

        val output = solver.rockPaperScissorsScore()

        assertEquals(expected, output)
    }

    @Test
    fun givenTestSetMethodShouldReturn12() {
        val expected = 12

        val output = solver.rockPaperScissorsScoreNextGen()

        assertEquals(expected, output)
    }
}