package medium

import ArraysTopic
import DynamicProgrammingTopic
import MatrixTopic

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */

class Medium221 : ArraysTopic, DynamicProgrammingTopic, MatrixTopic {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix.first().isEmpty()) return 0
        val dp = Array(matrix.size + 1) { IntArray(matrix.first().size + 1) }
        var maxsqlen = 0
        for (i in 1..matrix.size) {
            for (j in 1..matrix.first().size) {
                if (matrix[i - 1][j - 1] == '1') {
                    val bb1 = dp[i][j - 1]
                    val bb2 = dp[i - 1][j]
                    val bb3 = dp[i - 1][j - 1]
                    val bb = minOf(bb1, bb2)
                    dp[i][j] = minOf(bb, bb3) + 1
                    maxsqlen = maxOf(maxsqlen, dp[i][j])
                }
            }
        }
        return maxsqlen * maxsqlen
    }
}

fun main() {
    val dd = Medium221().maximalSquare(
        arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
        )
    )
    println(dd)
}