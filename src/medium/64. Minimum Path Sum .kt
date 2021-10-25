package medium

import ArraysTopic
import DynamicProgrammingTopic
import MatrixTopic

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

class Medium64: ArraysTopic, DynamicProgrammingTopic, MatrixTopic {

    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i == 0) {
                    if (j != 0) {
                        grid[i][j] += grid[i][j - 1]
                    }
                } else {
                    if (j != 0) {
                        grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j])
                    } else {
                        grid[i][j] += grid[i - 1][j]
                    }
                }
            }
        }
        return grid.last().last()
    }
}

fun main() {
    val data = arrayOf(
        intArrayOf(1,3,1),
        intArrayOf(1,5,1),
        intArrayOf(4,2,1)
    )
    println(Medium64().minPathSum(data))
    val data1 = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6)
    )
    println(Medium64().minPathSum(data1))
}