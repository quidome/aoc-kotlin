package me.quido.year2022.day02

import me.quido.util.getInputAsText

fun main() {
    val input = getInputAsText(2022, 2) ?: error("Input file does not exist")
    val solver = Day02(input)

    println(solver.part1())
    println(solver.part2())
}


class Day02(private val input: String) {
    fun part1(): Int {
        var myScore = 0
        val turns = turnsTranslatedToScores()

        for (turn in turns) {
            myScore += turn[1]
            myScore += pointsForDuel(turn)
        }
        return myScore
    }


    fun part2(): Int {
        var myScore = 0
        val turns = turnsTranslatedToScores()

        for (turn in turns) {
            val myResponse = selectResponse(turn)
            myScore += myResponse
            myScore += pointsForDuel(intArrayOf(turn[0], myResponse))
        }
        return myScore
    }


    private fun turnsTranslatedToScores(): List<IntArray> {
        val turns = input.split("\n")
            .map { it.split(" ") }
            .map { turnsListToInts(it) }
        return turns
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
        val returnValues = mapOf("A" to 1 , "B" to 2, "C" to 3, "X" to 1, "Y" to 2, "Z" to 3)
        return returnValues.getValue(turn)
    }


    private fun selectResponse(turn: IntArray): Int {
        val theirTurn = turn[0]
        val requiredResponse = turn[1]

        when (requiredResponse) {
            1 -> return previousWeapon(theirTurn)
            2 -> return theirTurn
            3 -> return nextWeapon(theirTurn)
        }

        error("$requiredResponse is not a valid response")
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
        ) {
            return true
        }
        return false
    }


    private fun nextWeapon(weapon: Int): Int {
        var returnValue = weapon + 1
        if (returnValue > 3) {
            returnValue = 1
        }
        return returnValue
    }


    private fun previousWeapon(weapon: Int): Int {
        var returnValue = weapon - 1
        if (returnValue < 1) {
            returnValue = 3
        }
        return returnValue
    }
}