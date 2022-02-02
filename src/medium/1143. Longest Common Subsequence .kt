package medium

import DynamicProgrammingTopic


/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 *
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 BULLSHIT
 */

class Medium1143 : DynamicProgrammingTopic {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }
        for (i in text1.lastIndex downTo 0) {
            for (j in text2.lastIndex downTo 0) {
                dp[i][j] = if (text1[i] == text2[j]) 1 + dp[i + 1][j + 1] else maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }
        return dp[0][0]
    }
}

fun main() {
    println(Medium1143().longestCommonSubsequence("abcde", "ace"))
    println(Medium1143().longestCommonSubsequence("abc", "abc"))
    println(Medium1143().longestCommonSubsequence("abc", "def"))
}