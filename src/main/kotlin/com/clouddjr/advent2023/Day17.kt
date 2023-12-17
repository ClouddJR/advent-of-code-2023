package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D
import java.util.PriorityQueue

class Day17(input: List<String>) {
    private val grid = input.map { row -> row.map { it.digitToInt() } }

    fun solvePart1(): Int {
        return findMinHeatLoss(
            initialStates = listOf(State(Point2D(0, 0), Point2D.EAST, 0)),
            minBlocks = 0,
            maxBlocks = 3
        )
    }

    fun solvePart2(): Int {
        return findMinHeatLoss(
            initialStates = listOf(State(Point2D(0, 0), Point2D.EAST, 0), State(Point2D(0, 0), Point2D.SOUTH, 0)),
            minBlocks = 4,
            maxBlocks = 10
        )
    }

    private fun findMinHeatLoss(initialStates: List<State>, minBlocks: Int, maxBlocks: Int): Int {
        val end = Point2D(grid.first().lastIndex, grid.lastIndex)

        val costs = mutableMapOf<State, Int>().withDefault { Int.MAX_VALUE }
        val toVisit = PriorityQueue<StateWithCost>()

        for (state in initialStates) {
            costs[state] = 0
            toVisit.add(StateWithCost(state, 0))
        }

        while (toVisit.isNotEmpty()) {
            val current = toVisit.poll()
            if (current.state.point == end) {
                return current.cost
            }

            current.state.next(minBlocks, maxBlocks)
                .filter { it.point.y in grid.indices && it.point.x in grid.first().indices }
                .forEach { next ->
                    val newCost = current.cost + grid[next.point.y][next.point.x]
                    if (newCost < costs.getValue(next)) {
                        costs[next] = newCost
                        toVisit.add(StateWithCost(next, newCost))
                    }
                }
        }

        error("No path found")
    }

    private data class State(val point: Point2D, val dir: Point2D, val blocks: Int) {
        fun next(minBlocks: Int, maxBlocks: Int) = buildList {
            when {
                blocks < minBlocks -> add(copy(point = point + dir, dir = dir, blocks = blocks + 1))
                else               -> {
                    val left = Point2D(dir.y, dir.x)
                    val right = Point2D(-dir.y, -dir.x)

                    add(copy(point = point + left, dir = left, blocks = 1))
                    add(copy(point = point + right, dir = right, blocks = 1))

                    if (blocks < maxBlocks) {
                        add(copy(point = point + dir, dir = dir, blocks = blocks + 1))
                    }
                }
            }
        }
    }

    private data class StateWithCost(val state: State, val cost: Int) : Comparable<StateWithCost> {
        override fun compareTo(other: StateWithCost): Int {
            return cost compareTo other.cost
        }
    }
}