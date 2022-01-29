package medium

import CombinatoricsTopic
import DynamicProgrammingTopic
import MathTopic

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */

class Medium62 : MathTopic, DynamicProgrammingTopic, CombinatoricsTopic {

    fun uniquePaths(m: Int, n: Int): Int {
        val array = Array(m + 1) { IntArray(n + 1) }
        array[1][0] = 1
        for (i in 1..m) {
            for (j in 1..n) {
                array[i][j] = array[i][j - 1] + array[i - 1][j];
            }
        }
        return array.last().last()
    }
}

fun main() {
    println(Medium62().uniquePaths(3, 7))
    println(Medium62().uniquePaths(7, 3))
    println(Medium62().uniquePaths(3, 3))
    println(Medium62().uniquePaths(3, 2))
}