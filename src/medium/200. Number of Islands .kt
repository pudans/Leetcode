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

    lateinit var visited: Array<BooleanArray>
    lateinit var grid: Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        this.grid = grid
        this.visited = Array(grid.size) {
            BooleanArray(grid[0].size) { false }
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '0') {
                    continue
                }
                if (visited[i][j]) {
                    continue
                }
                findLand(i, j)
                println("-----------")
                result++
            }
        }
        return result
    }

    private fun findLand(i: Int, j: Int) {
        println("$i-$j")
        if (grid[i][j] == '0') {
            return
        }
        if (visited[i][j]) {
            return
        }
        visited[i][j] = true
        if (i < grid.size - 1) {
            findLand(i + 1, j)
        }
        if (j < grid[i].size - 1) {
            findLand(i, j + 1)
        }
        if (j > 0) {
            findLand(i, j - 1)
        }
        if (i > 0) {
            findLand(i - 1, j)
        }
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