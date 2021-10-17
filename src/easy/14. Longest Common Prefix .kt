package easy

import StringTopic

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */

class Easy14: StringTopic {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val targetValue = strs[0]
        var prefixCount = 0
        for (i in targetValue.indices) {
            val ch = targetValue[i]
            val hasPrefix = strs.all { it.getOrNull(i) == ch }
            if (hasPrefix) prefixCount++ else break
        }
        return if (prefixCount == 0) "" else targetValue.substring(0, prefixCount)
    }
}

fun main() {
    println(Easy14().longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(Easy14().longestCommonPrefix(arrayOf("dog","racecar","car")))
}