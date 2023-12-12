package com.clouddjr.advent2023

class Day12(input: List<String>) {
    private val springs = input.map { it.substringBefore(" ") to it.substringAfter(" ").split(",").map(String::toInt) }
    private val cache = mutableMapOf<State, Long>()

    fun solvePart1(): Long {
        return springs.sumOf { (conditions, groups) ->
            getArrangements("$conditions.", groups, 0, 0, 0).also { cache.clear() }
        }
    }

    fun solvePart2(): Long {
        return springs
            .map { (condition, groups) -> List(5) { condition }.joinToString("?") to List(5) { groups }.flatten() }
            .sumOf { (conditions, groups) ->
                getArrangements("$conditions.", groups, 0, 0, 0).also { cache.clear() }
            }
    }

    private fun getArrangements(conditions: String, groups: List<Int>, pos: Int, group: Int, groupLen: Int): Long {
        return cache.getOrPut(State(pos, group, groupLen)) {
            if (pos == conditions.length) {
                return if (group == groups.size && groupLen == 0) 1 else 0
            }

            var sum = 0L

            if (conditions[pos] in ".?") {
                if (group < groups.size && groupLen == groups[group]) {
                    sum += getArrangements(conditions, groups, pos + 1, group + 1, 0)
                }
                if (groupLen == 0) {
                    sum += getArrangements(conditions, groups, pos + 1, group, groupLen)
                }
            }

            if (conditions[pos] in "#?") {
                sum += getArrangements(conditions, groups, pos + 1, group, groupLen + 1)
            }

            sum
        }
    }

    private data class State(val pos: Int, val group: Int, val groupLen: Int)
}