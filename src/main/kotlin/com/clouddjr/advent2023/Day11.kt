package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D
import kotlin.math.abs

class Day11(private val input: List<String>) {
    fun solvePart1(): Long {
        return sumOfDistances(expandBy = 2)
    }

    fun solvePart2(): Long {
        return sumOfDistances(expandBy = 1_000_000)
    }

    private fun sumOfDistances(expandBy: Int): Long {
        val sumRows = input.runningFold(0) { prev, row ->
            if (row.any { it == '#' }) prev else prev + 1
        }

        val sumCols = input.first().indices.map { colIdx -> input.map { row -> row[colIdx] } }.runningFold(0) { prev, col ->
            if (col.any { it == '#' }) prev else prev + 1
        }

        val galaxies = input.flatMapIndexed { rowIdx, row ->
            row.mapIndexed { colIdx, c ->
                if (c == '#') {
                    Point2D(
                        x = colIdx + sumCols[colIdx] * (expandBy - 1),
                        y = rowIdx + sumRows[rowIdx] * (expandBy - 1)
                    )
                } else null
            }.filterNotNull()
        }

        return (0..<galaxies.size - 1).sumOf { i ->
            (i + 1..<galaxies.size).sumOf { j ->
                abs(galaxies[j].x - galaxies[i].x) + abs(galaxies[j].y - galaxies[i].y).toLong()
            }
        }
    }
}