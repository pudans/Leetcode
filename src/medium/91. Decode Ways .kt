package medium

import DynamicProgrammingTopic
import StringTopic

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 *
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above
 * (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * The answer is guaranteed to fit in a 32-bit integer.
 */

class Medium91: StringTopic, DynamicProgrammingTopic {

    /**
     * Bullshit
     */

    fun numDecodings(s: String): Int {
        return noWeyTab(s)
    }

    private fun noWeyTab(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val n = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = if (s[0] != '0') 1 else 0
        for (i in 2..n) {
            val first = Integer.valueOf(s.substring(i - 1, i))
            val second = Integer.valueOf(s.substring(i - 2, i))
            if (first in 1..9) {
                dp[i] += dp[i - 1]
            }
            if (second in 10..26) {
                dp[i] += dp[i - 2]
            }
        }
        return dp[n]
    }
}

fun main() {
    println(Medium91().numDecodings("12"))
    println(Medium91().numDecodings("226"))
    println(Medium91().numDecodings("0"))
    println(Medium91().numDecodings("06"))

}