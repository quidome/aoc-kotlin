package me.quido.year2022.day3

import me.quido.util.getInputAsText

fun main() {
    val input = getInputAsText(2022, 0) ?: error("Input file does not exist")
    val solver = Day3(input)

    println(solver.part1())
    println(solver.part2())
}


class Day3(private val input: String) {
    fun part1(): Int {
        println(input)
        return 1
    }


    fun part2(): Int {
        return 2
    }
}