package hard

import DynamicProgrammingTopic
import StringTopic


/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 *
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character

BULLSHIT
 */

class Hard72 : StringTopic, DynamicProgrammingTopic {

    fun minDistance(
        word1: String,
        word2: String,
        i: Int = 0,
        j: Int = 0,
        dp: Array<IntArray> = Array(word1.length) { IntArray(word2.length) }
    ): Int {
        if (i >= word1.length) return word2.length - j
        if (j >= word2.length) return word1.length - i
        if (dp[i][j] != 0) return dp[i][j]
        return if (word1[i] == word2[j]) {
            minDistance(word1, word2, i + 1, j + 1, dp).also { dp[i][j] = it }
        } else {
            val insert = minDistance(word1, word2, i, j + 1, dp)
            val delete = minDistance(word1, word2, i + 1, j, dp)
            val replace = minDistance(word1, word2, i + 1, j + 1, dp)
            (1 + minOf(replace, insert, delete)).also { dp[i][j] = it }
        }
    }
}

fun main() {
    println(Hard72().minDistance("horse", "ros"))
    println(Hard72().minDistance("intention", "execution"))
}