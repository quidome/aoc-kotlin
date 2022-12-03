package me.quido.year2022.day01

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day01Test {
    private val input = """
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

    private val solver = Day01(input)

    @ParameterizedTest
    @CsvSource(
        "1, 24000",
        "3, 45000"
    )
    fun getCaloriesFromANumberOfElves(elves: Int, expected: Int) {
        assertEquals(expected, solver.getCaloriesCarriedByTheTopElves(elves))
    }
}