package com.clouddjr.advent2023

class Day01(private val input: List<String>) {
    private val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    fun solvePart1(): Int {
        return input.sumOf { line ->
            line.first { it.isDigit() }.digitToInt() * 10 + line.last { it.isDigit() }.digitToInt()
        }
    }

    fun solvePart2(): Int {
        return input.sumOf { line ->
            line.firstDigit(fromStart = true) * 10 + line.firstDigit(fromStart = false)
        }
    }

    private fun String.firstDigit(fromStart: Boolean): Int {
        val range = if (fromStart) indices else indices.reversed()

        for (i in range) {
            if (get(i).isDigit()) {
                return get(i).digitToInt()
            }
            for ((d, number) in numbers.withIndex()) {
                if (substring(i).startsWith(number)) {
                    return d + 1
                }
            }
        }

        error("No digit found")
    }
}