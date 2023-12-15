package com.clouddjr.advent2023

class Day13(input: String) {
    private val patterns = input.split("\n\n").map { it.lines() }

    fun solvePart1(): Int {
        return patterns.sumOf { it.reflection(withSmudge = false) }
    }

    fun solvePart2(): Int {
        return patterns.sumOf { it.reflection(withSmudge = true) }
    }

    private fun List<String>.reflection(withSmudge: Boolean): Int {
        (lastIndex downTo 1)
            .firstOrNull { row -> hasReflection(0, row, withSmudge) }
            ?.let { row -> return 100 * (row + 1) / 2 }
        (1..<lastIndex)
            .firstOrNull { row -> hasReflection(row, lastIndex, withSmudge) }
            ?.let { row -> return 100 * (row + (lastIndex - row + 1) / 2) }

        val cols = first.indices.map { col -> map { it[col] }.joinToString("") }

        (cols.lastIndex downTo 1)
            .firstOrNull { col -> cols.hasReflection(0, col, withSmudge) }
            ?.let { col -> return (col + 1) / 2 }
        (1..<cols.lastIndex)
            .firstOrNull { col -> cols.hasReflection(col, cols.lastIndex, withSmudge) }
            ?.let { col -> return col + (cols.lastIndex - col + 1) / 2 }

        error("No reflection found")
    }

    private fun List<String>.hasReflection(start: Int, end: Int, withSmudge: Boolean): Boolean {
        if ((end - start + 1) % 2 == 1) return false

        val errors = (start..start + (end - start) / 2).sumOf { i ->
            this[i].indices.count { c -> this[i][c] != this[end - i + start][c] }
        }

        return errors == if (withSmudge) 1 else 0
    }
}