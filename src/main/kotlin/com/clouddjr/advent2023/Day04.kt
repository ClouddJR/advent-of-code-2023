package com.clouddjr.advent2023

import kotlin.math.pow

class Day04(input: List<String>) {
    private val cards = input.map { Card.from(it) }

    private val winning = cards.withIndex().associate { (index, card) ->
        index + 1 to card.mine.intersect(card.winning).size
    }

    fun solvePart1(): Int {
        return winning.values.sumOf { 2.0.pow(it - 1).toInt() }
    }

    fun solvePart2(): Int {
        val copies = cards.indices.associate { it + 1 to 1 }.toMutableMap()

        winning.forEach { (card, winning) ->
            (card + 1..card + winning).forEach { idx ->
                copies[idx] = copies.getOrDefault(idx, 0) + copies.getValue(card)
            }
        }

        return copies.values.sum()
    }

    private data class Card(val winning: Set<Int>, val mine: Set<Int>) {
        companion object {
            val pattern = """\s+""".toRegex()

            fun from(line: String): Card {
                val winning = line.substringAfter(":").substringBefore("|").trim().split(pattern).map { it.toInt() }.toSet()
                val mine = line.substringAfter("|").trim().split(pattern).map { it.toInt() }.toSet()
                return Card(winning, mine)
            }
        }
    }
}