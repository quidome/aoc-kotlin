package me.quido.util

fun getInputAsText(year: Int, day: Int): String? =
    object {}.javaClass.getResource("/input/year$year/day${day}.txt")?.readText()?.trimEnd()