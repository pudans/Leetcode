package easy

import DynamicProgrammingTopic
import StringTopic
import TwoPointersTopic

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/submissions/
 *
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

class Easy392 : TwoPointersTopic, StringTopic, DynamicProgrammingTopic {

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        if (t.isEmpty()) return false
        var i = 0
        return t.any {
            if (s[i] == it) i++
            i == s.length
        }
    }
}

fun main() {
    println(Easy392().isSubsequence("abc", "ahbgdc"))
    println(Easy392().isSubsequence("axc", "ahbgdc"))
}