package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D

class Day16(input: List<String>) {
    private val grid = input.map { it.toCharArray() }.toTypedArray()

    fun solvePart1(): Int {
        return score(startingBeam = Beam(Point2D(-1, 0), Point2D.EAST))
    }

    fun solvePart2(): Int {
        val top = grid.first().indices.map { Beam(Point2D(it, -1), Point2D.SOUTH) }
        val bottom = grid.first().indices.map { Beam(Point2D(it, grid.size), Point2D.NORTH) }
        val left = grid.indices.map { Beam(Point2D(-1, it), Point2D.EAST) }
        val right = grid.indices.map { Beam(Point2D(grid.first().size, it), Point2D.WEST) }

        return (top + bottom + left + right).maxOf { score(startingBeam = it) }
    }

    private fun score(startingBeam: Beam): Int {
        val seen = mutableSetOf<Beam>()

        val queue = ArrayDeque(listOf(startingBeam))

        while (queue.isNotEmpty()) {
            var current = queue.removeFirst()

            while (current !in seen) {
                seen.add(current)

                val nextPoint = current.point + current.dir
                var nextDir = current.dir

                if (nextPoint.y !in grid.indices || nextPoint.x !in grid.first().indices) {
                    break
                }

                when (grid[nextPoint.y][nextPoint.x]) {
                    '/'  -> nextDir = Point2D(-nextDir.y, -nextDir.x)
                    '\\' -> nextDir = Point2D(nextDir.y, nextDir.x)
                    '-'  -> if (nextDir.y != 0) {
                        nextDir = Point2D.EAST
                        queue.add(Beam(nextPoint, Point2D.WEST))
                    }
                    '|'  -> if (nextDir.x != 0) {
                        nextDir = Point2D.NORTH
                        queue.add(Beam(nextPoint, Point2D.SOUTH))
                    }
                }

                current = Beam(nextPoint, nextDir)
            }
        }

        return seen.map { it.point }.toSet().size - 1
    }

    private data class Beam(val point: Point2D, val dir: Point2D)
}