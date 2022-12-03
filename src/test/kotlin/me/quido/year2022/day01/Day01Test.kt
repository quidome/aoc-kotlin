package me.quido.year2022.day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    private val day = Day01()

    @Test
    fun getHighestCaloriesFromElves() {
        val expected = 24000
        val input = """
                 1000
                 2000
                 3000

                 4000

                 5000
                 6000

                 7000
                 8000
                 9000

                 10000
                 
        """.trimIndent().trimEnd()

        val output = day.getHighestCalorieCountFromElves(input)

        assertEquals(expected, output)
    }
}