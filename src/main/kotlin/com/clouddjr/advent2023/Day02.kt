package com.clouddjr.advent2023

class Day02(input: List<String>) {
    private val games = input.map { Game.from(it) }

    fun solvePart1(): Int {
        return games.withIndex()
            .filter { (_, game) -> game.bags.all { bag -> bag.red <= 12 && bag.green <= 13 && bag.blue <= 14 } }
            .sumOf { it.index + 1 }
    }

    fun solvePart2(): Int {
        return games.sumOf { it.powerOfMinSet() }
    }

    private data class Game(val bags: List<Bag>) {
        fun powerOfMinSet(): Int {
            return bags.maxOf { it.red } * bags.maxOf { it.green } * bags.maxOf { it.blue }
        }

        companion object {
            fun from(line: String): Game {
                val bags = line.substringAfter(": ").split("; ").map { Bag.from(it) }
                return Game(bags)
            }
        }
    }

    private data class Bag(val red: Int, val green: Int, val blue: Int) {
        companion object {
            fun from(line: String): Bag {
                val cubes = line.split(", ").associate { cube ->
                    val (value, color) = cube.split(" ")
                    color to value.toInt()
                }.withDefault { 0 }

                return Bag(cubes.getValue("red"), cubes.getValue("green"), cubes.getValue("blue"))
            }
        }
    }
}