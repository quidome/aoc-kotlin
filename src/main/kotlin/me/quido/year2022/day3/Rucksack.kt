package me.quido.year2022.day3

class Rucksack(contents: String) {
    var compartmentA = setOf<Char>()
    var compartmentB = setOf<Char>()

    init {
        val ruckSackSeparator = contents.length / 2
        compartmentA = contents.substring(0,ruckSackSeparator ).toSet()
        compartmentB = contents.substring(ruckSackSeparator, contents.length).toSet()
    }

    fun itemIntersection(): Set<Char> {
        return compartmentA.intersect(compartmentB)
    }
}