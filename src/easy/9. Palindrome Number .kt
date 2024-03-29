package easy

import MathTopic

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 */

class Easy9: MathTopic{

    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        for (i in 0 until (str.length / 2)) {
            if (str[i] != str[str.length - 1 - i]) return false
        }
        return true
    }

    fun isPalindrome2(x: Int): Boolean {
        val str = x.toString()
        return str == str.reversed()
    }
}

fun main() {
    println(Easy9().isPalindrome(121))
    println(Easy9().isPalindrome(-121))
    println(Easy9().isPalindrome(10))
    println(Easy9().isPalindrome(-101))
}