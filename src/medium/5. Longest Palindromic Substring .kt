package medium

import DynamicProgrammingTopic
import StringTopic

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 */

class Medium5: DynamicProgrammingTopic, StringTopic {

    fun longestPalindrome(str: String): String {
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
                result+=2
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
                result+=2
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