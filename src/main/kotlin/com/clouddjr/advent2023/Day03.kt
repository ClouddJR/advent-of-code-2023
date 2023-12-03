package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D

class Day03(input: List<String>) {
    private val engine = parseEngineSchema(input)

    fun solvePart1() = engine.sumOfPartNumbers

    fun solvePart2() = engine.sumOfGearRatios

    private fun parseEngineSchema(input: List<String>): EngineSchema {
        var sumOfPartNumbers = 0
        val asterisks = mutableMapOf<Point2D, MutableList<Int>>()

        input.forEachIndexed { y, line ->
            var x = 0
            while (x < line.length) {
                if (!line[x].isDigit()) {
                    x++
                    continue
                }

                val number = line.substring(x).takeWhile { it.isDigit() }

                val top = (x..<x + number.length).map { Point2D(it, y - 1) }
                val bottom = (x..<x + number.length).map { Point2D(it, y + 1) }
                val left = (y - 1..y + 1).map { Point2D(x - 1, it) }
                val right = (y - 1..y + 1).map { Point2D(x + number.length, it) }

                listOf(top, bottom, left, right).flatten()
                    .filter { it.y in input.indices && it.x in line.indices }
                    .forEach { n ->
                        if (input[n.y][n.x] != '.') {
                            sumOfPartNumbers += number.toInt()
                        }
                        if (input[n.y][n.x] == '*') {
                            asterisks.getOrPut(n) { mutableListOf() }.add(number.toInt())
                        }
                    }

                x += number.length
            }
        }

        return EngineSchema(
            sumOfPartNumbers = sumOfPartNumbers,
            sumOfGearRatios = asterisks.filterValues { it.size == 2 }.values.sumOf { it.reduce { acc, i -> acc * i } }
        )
    }

    private data class EngineSchema(
        val sumOfPartNumbers: Int,
        val sumOfGearRatios: Int
    )
}