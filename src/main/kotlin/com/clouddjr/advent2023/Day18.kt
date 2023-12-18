package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D

class Day18(input: List<String>) {
    private val digs = input.map { Dig.from(it, usingColor = false) }
    private val correctDigs = input.map { Dig.from(it, usingColor = true) }

    fun solvePart1(): Long {
        return lavaCubicMeters(digs)
    }

    fun solvePart2(): Long {
        return lavaCubicMeters(correctDigs)
    }

    private fun lavaCubicMeters(digs: List<Dig>): Long {
        val border = digs.sumOf { it.meters }
        val vertices = digs.runningFold(Point2D(0, 0)) { last, dig -> last + dig.dir * dig.meters }
        val interior = shoelaceArea(vertices) - (border / 2) + 1

        return interior + border
    }

    private fun shoelaceArea(vertices: List<Point2D>): Long {
        return vertices.indices.sumOf { i ->
            val (x1, y1) = vertices[i]
            val (x2, y2) = vertices[(i + 1) % vertices.size]
            x1.toLong() * y2 - y1.toLong() * x2
        } / 2
    }

    private data class Dig(val dir: Point2D, val meters: Int) {
        companion object {
            private val mapping = mapOf(
                'U' to Point2D.NORTH, 'D' to Point2D.SOUTH, 'L' to Point2D.WEST, 'R' to Point2D.EAST,
                '3' to Point2D.NORTH, '1' to Point2D.SOUTH, '2' to Point2D.WEST, '0' to Point2D.EAST,
            )

            fun from(line: String, usingColor: Boolean): Dig {
                val (dir, meters, color) = line.split(" ")
                return Dig(
                    dir = if (usingColor) mapping.getValue(color[7]) else mapping.getValue(dir.single()),
                    meters = if (usingColor) color.substring(2..6).toInt(16) else meters.toInt(),
                )
            }
        }
    }
}