package me.quido.year2022.day02

import me.quido.util.getInputAsText

fun main() {
    val input = getInputAsText(2022, 2) ?: error("Input file does not exist")
    val solver = Day02(input)

    println(solver.rockPaperScissorsScore())
    println(solver.rockPaperScissorsScoreNextGen())
}


class Day02(private val input: String) {
    private var myScore = 0

    fun rockPaperScissorsScore(): Int {
        val turns = input.split("\n")
            .map { it.split(" ") }
            .map {turnsListToInts(it)}

        println("=== start printing ===")
        for (line in turns) {
            myScore += line[1]
            myScore += pointsForDuel(line)
        }
        return myScore
    }

    fun rockPaperScissorsScoreNextGen(): Int {
        return 12
    }

    private fun pointsForDuel(turns: IntArray): Int {
        if (turns[0] == turns[1]) {
            return 3
        } else if (weWin(turns[0], turns[1])) {
            return 6
        }

        return 0
    }

    private fun weWin(theirTurn: Int, ourTurn: Int): Boolean {
        if (
            ourTurn == 1 && theirTurn == 3 ||
            ourTurn == 2 && theirTurn == 1 ||
            ourTurn == 3 && theirTurn == 2
        )
            {
            return true
        }
        return false
    }

    private fun turnsListToInts(weapons: List<String>): IntArray {
        var returnValue = intArrayOf()

        val itr = weapons.listIterator()
        while (itr.hasNext()) {
            returnValue += turnToInt(itr.next())
        }
        return returnValue
    }

    private fun turnToInt(turn: String): Int {
        when (turn) {
            "A", "X" -> return 1
            "B", "Y" -> return 2
            "C", "Z" -> return 3
        }
        return 0
    }

}