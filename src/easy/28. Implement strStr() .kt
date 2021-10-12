package easy

/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

class Solution28 {

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        for (i in 0 until (haystack.length - needle.length)) {
            var has = true
            for (j in needle.indices) {
                has = has && haystack[i+j] == needle[j]
            }
            if (has) return i
        }
        return -1
    }
}

fun main() {
    println(Solution28().strStr(haystack = "hello", needle = "ll"))
    println(Solution28().strStr(haystack = "aaaaa", needle = "bba"))
    println(Solution28().strStr(haystack = "", needle = ""))
}