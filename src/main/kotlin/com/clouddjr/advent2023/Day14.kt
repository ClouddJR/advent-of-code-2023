package com.clouddjr.advent2023

class Day14(input: List<String>) {
    private val grid = input.map { it.toCharArray() }.toTypedArray()
    private val cache = mutableMapOf<String, Int>()

    fun solvePart1(): Int {
        tilt(Dir.NORTH)
        return load()
    }

    fun solvePart2(): Int {
        val total = 1_000_000_000

        repeat(total) { cycle ->
            val state = grid.joinToString("") { it.joinToString("") }

            if (state in cache) {
                val length = cycle - cache.getValue(state)
                val remainingCycles = (total - cycle) % length
                repeat(remainingCycles) { cycle() }
                return load()
            }

            cache[state] = cycle
            cycle()
        }

        return load()
    }

    private fun cycle() {
        tilt(Dir.NORTH)
        tilt(Dir.WEST)
        tilt(Dir.SOUTH)
        tilt(Dir.EAST)
    }

    private fun tilt(dir: Dir) {
        when (dir) {
            Dir.NORTH -> {
                for (c in grid.first().indices) {
                    var obstacle = -1
                    for (r in grid.indices) {
                        if (grid[r][c] == '#') {
                            obstacle = r
                        }
                        if (grid[r][c] == 'O') {
                            grid[r][c] = '.'
                            grid[++obstacle][c] = 'O'
                        }
                    }
                }
            }
            Dir.WEST  -> {
                for (r in grid.indices) {
                    var obstacle = -1
                    for (c in grid.first().indices) {
                        if (grid[r][c] == '#') {
                            obstacle = c
                        }
                        if (grid[r][c] == 'O') {
                            grid[r][c] = '.'
                            grid[r][++obstacle] = 'O'
                        }
                    }
                }
            }
            Dir.SOUTH -> {
                for (c in grid.last().indices) {
                    var obstacle = grid.size
                    for (r in grid.indices.reversed()) {
                        if (grid[r][c] == '#') {
                            obstacle = r
                        }
                        if (grid[r][c] == 'O') {
                            grid[r][c] = '.'
                            grid[--obstacle][c] = 'O'
                        }
                    }
                }
            }
            Dir.EAST  -> {
                for (r in grid.indices) {
                    var obstacle = grid.first().size
                    for (c in grid.first().indices.reversed()) {
                        if (grid[r][c] == '#') {
                            obstacle = c
                        }
                        if (grid[r][c] == 'O') {
                            grid[r][c] = '.'
                            grid[r][--obstacle] = 'O'
                        }
                    }
                }
            }
        }
    }

    private fun load() = grid.withIndex().sumOf { (r, row) -> row.count { it == 'O' } * (grid.size - r) }

    private enum class Dir {
        NORTH, WEST, SOUTH, EAST
    }
}