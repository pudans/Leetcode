package medium

import ArraysTopic
import BFSTopic
import DFSTopic
import MatrixTopic

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

class Medium200 : ArraysTopic, MatrixTopic, DFSTopic, BFSTopic {

    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        val visited = Array(grid.size) { BooleanArray(grid.first().size) }
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (findLand(i, j, grid, visited)) {
                    result++
                }
            }
        }
        return result
    }

    private fun findLand(i: Int, j: Int, grid: Array<CharArray>, visited: Array<BooleanArray>): Boolean {
        if (i !in grid.indices) return false
        if (j !in grid.first().indices) return false
        if (grid[i][j] == '0') return false
        if (visited[i][j]) return false
        visited[i][j] = true
        findLand(i + 1, j, grid, visited)
        findLand(i, j + 1, grid, visited)
        findLand(i, j - 1, grid, visited)
        findLand(i - 1, j, grid, visited)
        return true
    }
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '0', '1', '0', '1'),
        charArrayOf('1', '1', '1', '0', '1')
    )
    println(Medium200().numIslands(grid))
}