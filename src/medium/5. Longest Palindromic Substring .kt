package medium

import DynamicProgrammingTopic
import StringTopic


/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 */

class Medium5 : DynamicProgrammingTopic, StringTopic {

    fun longestPalindrome(s: String?): String {
        if (s == null || s.isEmpty()) return ""
        var start = 0
        var end = 0
        fun expandAroundCenter(s: String, left: Int, right: Int): Int {
            var L = left
            var R = right
            while (L >= 0 && R < s.length && s[L] == s[R]) {
                L--; R++
            }
            return R - L - 1
        }
        for (i in s.indices) {
            val len1 = expandAroundCenter(s, i, i)
            val len2 = expandAroundCenter(s, i, i + 1)
            val len = maxOf(len1, len2)
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    // mine
    fun longestPalindrome1(str: String): String {
        if (str.length == 1) {
            return str
        }
        var maxResult = 0
        var result = ""
        for (i in 1 until str.length) {
            val curUnevenMaxResult = getUnevenMaxPalindrome(str, i)
            val curEvenMaxResult = getEvenMaxPalindrome(str, i)
            if (curUnevenMaxResult > maxResult && curUnevenMaxResult > curEvenMaxResult) {
                maxResult = curUnevenMaxResult
                result = str.substring(i - curUnevenMaxResult / 2, i + 1 + curUnevenMaxResult / 2)
            }
            if (curEvenMaxResult > maxResult && curEvenMaxResult > curUnevenMaxResult) {
                maxResult = curEvenMaxResult
                result = str.substring(i - curEvenMaxResult / 2, i + curEvenMaxResult / 2)
            }
        }
        return result
    }

    private fun getUnevenMaxPalindrome(str: String, i: Int): Int {
        var start = i - 1
        var end = i + 1
        var result = 1
        while (start >= 0 && end < str.length) {
            if (str[start] != str[end]) {
                return result
            } else {
                start--
                end++
                result += 2
            }
        }
        return result
    }

    private fun getEvenMaxPalindrome(str: String, i: Int): Int {
        var start = i - 1
        var end = i
        var result = 0
        while (start >= 0 && end < str.length) {
            if (str[start] != str[end]) {
                return result
            } else {
                start--
                end++
                result += 2
            }
        }
        return result
    }
}

fun main() {
    println(Medium5().longestPalindrome("babad"))
    println(Medium5().longestPalindrome("cbbd"))
    println(Medium5().longestPalindrome("bb"))
    println(Medium5().longestPalindrome("ac"))
}