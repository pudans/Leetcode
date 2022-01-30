package medium

import DynamicProgrammingTopic
import StringTopic
import Tree.Traversal.LevelOrder.result


/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 */

class Medium5 : DynamicProgrammingTopic, StringTopic {

//    fun longestPalindrome(s: String?): String {
//        if (s == null || s.isEmpty()) return ""
//        var start = 0
//        var end = 0
//        fun expandAroundCenter(s: String, left: Int, right: Int): Int {
//            var L = left
//            var R = right
//            while (L >= 0 && R < s.length && s[L] == s[R]) {
//                L--; R++
//            }
//            return R - L - 1
//        }
//        for (i in s.indices) {
//            val len1 = expandAroundCenter(s, i, i)
//            val len2 = expandAroundCenter(s, i, i + 1)
//            val len = maxOf(len1, len2)
//            if (len > end - start) {
//                start = i - (len - 1) / 2
//                end = i + len / 2
//            }
//        }
//        return s.substring(start, end + 1)
//    }

    // mine
    fun longestPalindrome(str: String): String {
        if (str.length == 1) return str
        var maxResult = 0
        var pos = 0
        for (i in 1 until str.length) {
            val curUnevenMaxResult = getMaxPalindrome(str, i - 1, i + 1)
            if (curUnevenMaxResult > maxResult) {
                maxResult = curUnevenMaxResult
                pos = i
            }
            val curEvenMaxResult = getMaxPalindrome(str, i - 1, i)
            if (curEvenMaxResult > maxResult) {
                maxResult = curEvenMaxResult
                pos = i
            }
        }
        return if (maxResult % 2 == 0) {
            str.substring(pos - maxResult / 2, pos + maxResult / 2)
        } else {
            str.substring(pos - maxResult / 2, pos + 1 + maxResult / 2)
        }
    }

    private fun getMaxPalindrome(str: String, start: Int, end: Int): Int {
        var start = start
        var end = end
        var result = (end - start - 1)
        while (start >= 0 && end < str.length) {
            if (str[start] != str[end]) {
                break
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