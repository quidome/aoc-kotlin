package me.quido.year2022.day3

import me.quido.util.getInputAsText

fun main() {
    val input = getInputAsText(2022, 3) ?: error("Input file does not exist")
    val solver = Day3(input)

    println("part 1: ${solver.part1()}")
    println("part 2: ${solver.part2()}")
}


class Day3(private val input: String) {

    fun part1(): Int {
        var totalPriority = 0
        for (line in input.split("\n")) {
            val rucksack = Rucksack(line)
            totalPriority += itemsPriority(rucksack.itemIntersection())
        }
        return totalPriority
    }


    fun part2(): Int {
        return 2
    }

    private fun itemsPriority(items: Set<Char>): Int {
        var priorityTotal = 0
        for (item in items) {
            priorityTotal += when (item.isUpperCase()) {
                true -> item.toInt() - 38
                false -> item.toInt() - 96
            }
        }
        return priorityTotal
    }
}