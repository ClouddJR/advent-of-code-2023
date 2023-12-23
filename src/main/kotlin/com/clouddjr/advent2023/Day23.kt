package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D

class Day23(private val grid: List<String>) {
    private val start = Point2D(1, 0)
    private val end = Point2D(grid.first.lastIndex - 1, grid.lastIndex)
    private val visited = Array(grid.size) { BooleanArray(grid.first.length) }

    fun solvePart1(): Int {
        return findMax(
            current = start,
            visited = visited,
            getNeighbours = { current ->
                when (grid[current.y][current.x]) {
                    '>' -> listOf(current.copy(x = current.x + 1) to 1)
                    '<' -> listOf(current.copy(x = current.x - 1) to 1)
                    'v' -> listOf(current.copy(y = current.y + 1) to 1)
                    '^' -> listOf(current.copy(y = current.y - 1) to 1)
                    else -> {
                        current.validNeighbours().map { it to 1 }
                    }
                }
            }
        )
    }

    fun solvePart2(): Int {
        val junctions = mutableMapOf(
            start to mutableListOf<Pair<Point2D, Int>>(),
            end to mutableListOf(),
        )

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '.') {
                    val point = Point2D(col, row)
                    if (point.validNeighbours().size > 2) {
                        junctions[point] = mutableListOf()
                    }
                }
            }
        }

        for (junction in junctions.keys) {
            var current = setOf(junction)
            val visited = mutableSetOf(junction)
            var distance = 0

            while (current.isNotEmpty()) {
                distance++
                current = buildSet {
                    for (c in current) {
                        c.validNeighbours().filter { it !in visited }.forEach { n ->
                            if (n in junctions) {
                                junctions.getValue(junction).add(n to distance)
                            } else {
                                add(n)
                                visited.add(n)
                            }
                        }
                    }
                }
            }
        }

        return findMax(
            current = start,
            visited = visited,
            getNeighbours = { current -> junctions.getValue(current) }
        )
    }

    private fun findMax(
        current: Point2D,
        visited: Array<BooleanArray>,
        distance: Int = 0,
        getNeighbours: (Point2D) -> List<Pair<Point2D, Int>>
    ): Int {
        if (current == end) {
            return distance
        }

        visited[current.y][current.x] = true
        val max = getNeighbours(current)
            .filter { (neighbour, _) -> !visited[neighbour.y][neighbour.x] }
            .maxOfOrNull { (neighbour, weight) ->
                findMax(neighbour, visited, distance + weight, getNeighbours)
            }
        visited[current.y][current.x] = false

        return max ?: 0
    }

    private fun Point2D.validNeighbours() = neighbours()
        .filter { it.y in grid.indices && it.x in grid.first().indices && grid[it.y][it.x] in ".<>^v" }
}