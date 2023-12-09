package com.clouddjr.advent2023

class Day09(input: List<String>) {
    private val histories = input.map { line -> line.split(" ").map { it.toInt() } }

    fun solvePart1(): Int {
        return histories.sumOf { next(it) }
    }

    fun solvePart2(): Int {
        return histories.map { it.reversed() }.sumOf { next(it) }
    }

    private fun next(diffs: List<Int>): Int {
        if (diffs.all { it == 0 }) {
            return 0
        }
        val n = (1..<diffs.size).map { i -> diffs[i] - diffs[i - 1] }
        return diffs.last + next(n)
    }
}