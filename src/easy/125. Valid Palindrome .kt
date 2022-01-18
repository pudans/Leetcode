package easy

import StringTopic
import TwoPointersTopic

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */

class Easy125 : StringTopic, TwoPointersTopic {

    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.lastIndex
        while (start < end) {
            when {
                !s[start].isLetterOrDigit() -> start++
                !s[end].isLetterOrDigit() -> end--
                s[start].equals(s[end], true) -> {
                    start++; end--
                }
                else -> return false
            }
        }
        return true
    }
}

fun main() {
    println(Easy125().isPalindrome("A man, a plan, a canal: Panama"))
    println(Easy125().isPalindrome("race a car"))
}