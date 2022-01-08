package hard

import DynamicProgrammingTopic
import MatrixTopic


/**
 * 1463. Cherry Pickup II
 * https://leetcode.com/problems/cherry-pickup-ii/
 *
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.
You have two robots that can collect cherries for you:
Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:
From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 */

class Hard1463 : MatrixTopic, DynamicProgrammingTopic {

    fun cherryPickup(grid: Array<IntArray>): Int {
        val dpCache = Array(grid.size) { Array(grid.first().size) { IntArray(grid.first().size) { -1 } } }
        return dp(0, 0, grid.first().lastIndex, grid, dpCache)
    }

    private fun dp(row: Int, col1: Int, col2: Int, grid: Array<IntArray>, dpCache: Array<Array<IntArray>>): Int {
        if (col1 < 0 || col1 >= grid[0].size || col2 < 0 || col2 >= grid[0].size) return 0
        if (dpCache[row][col1][col2] != -1) return dpCache[row][col1][col2]
        var result = grid[row][col1]
        if (col1 != col2) {
            result += grid[row][col2]
        }
        if (row != grid.size - 1) {
            var max = 0
            for (newCol1 in col1 - 1..col1 + 1) {
                for (newCol2 in col2 - 1..col2 + 1) {
                    max = maxOf(max, dp(row + 1, newCol1, newCol2, grid, dpCache))
                }
            }
            result += max
        }
        dpCache[row][col1][col2] = result
        return result
    }
}

fun main() {
    println(
        Hard1463().cherryPickup(
            arrayOf(
                intArrayOf(3, 1, 1),
                intArrayOf(2, 5, 1),
                intArrayOf(1, 5, 5),
                intArrayOf(2, 1, 1)
            )
        )
    )
//    println(Hard878().nthMagicalNumber(4, 2, 3))
//    println(Hard878().nthMagicalNumber(5, 2, 4))
//    println(Hard878().nthMagicalNumber(3, 6, 4))
}