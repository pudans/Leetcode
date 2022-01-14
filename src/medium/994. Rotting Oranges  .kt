package medium

import ArraysTopic
import BFSTopic
import MatrixTopic

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 *
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */

class Medium994 : ArraysTopic, BFSTopic, MatrixTopic {

    fun orangesRotting(grid: Array<IntArray>): Int {
        var fresh = -1
        var beRotten = 0
        var result = 1

        while (fresh != 0) {
            result++
            fresh = 0
            beRotten = 0
            for (i in grid.indices) {
                for (j in 0 until grid.first().size) {
                    if (grid[i][j] == 1) {
                        val d1 = grid.getOrNull(i - 1)?.getOrNull(j)?.let { it == 2 || it == -result + 1 } ?: false
                        val d2 = grid.getOrNull(i + 1)?.getOrNull(j)?.let { it == 2 || it == -result + 1 } ?: false
                        val d3 = grid.getOrNull(i)?.getOrNull(j - 1)?.let { it == 2 || it == -result + 1 } ?: false
                        val d4 = grid.getOrNull(i)?.getOrNull(j + 1)?.let { it == 2 || it == -result + 1 } ?: false

                        if (d1 || d2 || d3 || d4) {
                            grid[i][j] = -result
                            beRotten++
                        } else {
                            val e1 = grid.getOrNull(i - 1)?.getOrNull(j)?.let { it == 0 } ?: true
                            val e2 = grid.getOrNull(i + 1)?.getOrNull(j)?.let { it == 0 } ?: true
                            val e3 = grid.getOrNull(i)?.getOrNull(j - 1)?.let { it == 0 } ?: true
                            val e4 = grid.getOrNull(i)?.getOrNull(j + 1)?.let { it == 0 } ?: true
                            if (e1 && e2 && e3 && e4) {
                                return -1
                            } else {
                                fresh++
                            }
                        }
                    }
                }
            }
            if (beRotten == 0 && fresh != 0) return -1
            if (beRotten == 0 && result == 2) return 0
        }
        return result - 1
    }
}

fun main() {
    println(Medium994().orangesRotting(arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))))
    println(Medium994().orangesRotting(arrayOf(intArrayOf(0, 2))))
    println(Medium994().orangesRotting(arrayOf(intArrayOf(2, 1, 1), intArrayOf(0, 1, 1), intArrayOf(1, 0, 1))))
    println(Medium994().orangesRotting(arrayOf(intArrayOf(1, 2))))
    println(Medium994().orangesRotting(arrayOf(intArrayOf(1, 1, 1, 1))))
}