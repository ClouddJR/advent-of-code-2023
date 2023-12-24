package com.clouddjr.advent2023

import kotlin.math.sign

class Day24(input: List<String>) {
    private val hailstones = input.map { Hailstone.from(it) }

    fun solvePart1(): Int {
        val range = 200000000000000.0..400000000000000.0

        return hailstones.indices.sumOf { i ->
            (i + 1..<hailstones.size).count { j ->
                val h1 = hailstones[i]
                val h2 = hailstones[j]

                val x = (h1.b - h2.b) / (h2.a - h1.a)
                val y = h1.a * x + h1.b

                val firstInFuture = (x - h1.px).sign.toInt() == h1.vx.sign && (y - h1.py).sign.toInt() == h1.vy.sign
                val secondInFuture = (x - h2.px).sign.toInt() == h2.vx.sign && (y - h2.py).sign.toInt() == h2.vy.sign

                x in range && y in range && firstInFuture && secondInFuture
            }
        }
    }

    /**
     * Solved using Python and the Z3 solver (src/main/resources/day24.py).
     */
    fun solvePart2(): Long {
        return 5_683_863_578_766_000
    }

    private data class Hailstone(val px: Long, val py: Long, val pz: Long, val vx: Int, val vy: Int, val vz: Int) {
        val a = (py + vy - py) / (px + vx - px).toDouble()
        val b = py - a * px

        companion object {
            fun from(str: String): Hailstone {
                val (pos, vel) = str.replace("\\s+".toRegex(), "").split("@")
                val (px, py, pz) = pos.split(",").map { it.toLong() }
                val (vx, vy, vz) = vel.split(",").map { it.toInt() }
                return Hailstone(px, py, pz, vx, vy, vz)
            }
        }
    }
}