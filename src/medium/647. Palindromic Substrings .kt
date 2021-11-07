package medium

import DynamicProgrammingTopic

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
 */

class Medium647 : DynamicProgrammingTopic {

    fun countSubstrings(str: String): Int {
        var result = 0
        for (i in str.indices) {
            for (j in i until str.length) {
                if (isPalindrom(str, i, j)) {
                    result++
                }
            }
        }
        return result
    }

    fun isPalindrom(str: String, start: Int, end: Int): Boolean {
        if (start == end) return true
        val middle = Math.ceil((end - start).toDouble() / 2f).toInt()

        for (i in 0 until middle) {
            if (str[start + i] != str[end - i]) {
                return false
            }
        }
        println("$str $start $end $middle")
        return true
    }
}

fun main() {
    println(Medium647().countSubstrings("aaa"))
}