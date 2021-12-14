package easy

import StringTopic

/**
 * 1446. Consecutive Characters
 * https://leetcode.com/problems/consecutive-characters/
 *
The power of the string is the maximum length of a non-empty substring that contains only one unique character.
Given a string s, return the power of s.
 */

class Easy1446 : StringTopic {

    fun maxPower(s: String): Int {
        var result = 0
        var localChar = ' '
        var localMax = 0
        for (i in s.indices) {
            val ch = s[i]
            when (localChar) {
                ch -> localMax++
                else -> {
                    result = maxOf(result, localMax)
                    localChar = ch
                    localMax = 1
                }
            }
        }
        return maxOf(result, localMax)
    }
}

fun main() {
    println(Easy1446().maxPower("leetcode"))
    println(Easy1446().maxPower("abbcccddddeeeeedcba"))
    println(Easy1446().maxPower("triplepillooooow"))
    println(Easy1446().maxPower("hooraaaaaaaaaaay"))
    println(Easy1446().maxPower("tourist"))
}