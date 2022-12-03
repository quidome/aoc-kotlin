package me.quido.year2022.day01

import me.quido.util.getInputAsText

fun main() {
    val input = getInputAsText(2022, 1) ?: error("Input file does not exist")

    val data = input.split("\n\n").map {
            elf -> elf.lines().map { it.toInt()}
    }
    println(data.maxOf {it.sum()})
//    println(Day01().getHighestCalorieCountFromElves(input))
}

class Day01 {
    fun getHighestCalorieCountFromElves(input: String): Int {
        val data = input.split("\n\n").map {
            elf -> elf.lines().map { it.toInt()}
        }
        return data.maxOf { it.sum()}
    }
}