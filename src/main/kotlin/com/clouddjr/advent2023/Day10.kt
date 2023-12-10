package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D
import kotlin.math.abs
import kotlin.math.ceil

class Day10(input: List<String>) {
    private val grid = input.map { it.toCharArray() }

    fun solvePart1(): Int {
        return ceil(getLoop().size / 2.0).toInt()
    }

    fun solvePart2(): Int {
        val loop = getLoop()
        val pipes = "|LJS"

        var count = 0

        for (y in grid.indices) {
            var inside = false
            for (x in grid.first().indices) {
                if (Point2D(x, y) in loop && grid[y][x] in pipes) {
                    inside = !inside
                }
                if (Point2D(x, y) !in loop && inside) {
                    count++
                }
            }
        }

        return count
    }

    private fun getLoop(): Set<Point2D> {
        var start = Point2D(0, 0)
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] == 'S') {
                    start = Point2D(x, y)
                }
            }
        }

        val toVisit = ArrayDeque(listOf(start))
        val visited = mutableSetOf(start)

        while (toVisit.isNotEmpty()) {
            val current = toVisit.removeLast()
            current.validNeighbours()
                .filter { n -> current.isConnected(n) && n !in visited }
                .forEach { n ->
                    toVisit.add(n)
                    visited.add(n)
                }
        }

        return visited
    }

    private fun Point2D.validNeighbours() = neighbours().filter { it.y in grid.indices && it.x in grid.first().indices }

    private fun Point2D.isConnected(other: Point2D): Boolean {
        return when {
            grid[y][x] == 'S' -> other.isConnected(this)
            grid[y][x] == '|' -> other.x == x && abs(other.y - y) == 1
            grid[y][x] == '-' -> other.y == y && abs(other.x - x) == 1
            grid[y][x] == 'L' -> (other.y == y - 1 && other.x == x) || (other.x == x + 1 && other.y == y)
            grid[y][x] == 'J' -> (other.y == y - 1 && other.x == x) || (other.x == x - 1 && other.y == y)
            grid[y][x] == '7' -> (other.y == y + 1 && other.x == x) || (other.x == x - 1 && other.y == y)
            grid[y][x] == 'F' -> (other.y == y + 1 && other.x == x) || (other.x == x + 1 && other.y == y)
            else              -> false
        }
    }
}