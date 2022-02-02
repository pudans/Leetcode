package medium

import DynamicProgrammingTopic

/**
 * 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
In one step, you can delete exactly one character in either string.
 */

class Medium583 : DynamicProgrammingTopic {

    fun minDistance(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
        for (i in 0..s1.length) {
            for (j in 0..s2.length) {
                if (i == 0 || j == 0) continue
                dp[i][j] = if (s1[i - 1] == s2[j - 1]) 1 + dp[i - 1][j - 1] else maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
        return s1.length + s2.length - 2 * dp.last().last()
    }
}

fun main() {
    println(Medium583().minDistance("sea", "eat"))
    println(Medium583().minDistance("leetcode", "etco"))
}