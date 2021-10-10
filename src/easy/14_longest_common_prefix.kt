package easy

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

class Solution14 {

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
    println(Solution14().longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(Solution14().longestCommonPrefix(arrayOf("dog","racecar","car")))
}