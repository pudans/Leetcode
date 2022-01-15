package easy

import GreedyTopic
import HashTableTopic


/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 *
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 BULLSHIT
 */

class Easy409 : GreedyTopic, HashTableTopic {

    fun longestPalindrome(s: String): Int {
        val count = HashMap<Char, Int>(128)
        for (char in s.toCharArray()) count[char] = count.getOrDefault(char, 0) + 1
        var ans = 0
        count.values.forEach { v ->
            ans += v / 2 * 2
            if (ans % 2 == 0 && v % 2 == 1) ans++
        }
        return ans
    }
}

fun main() {
    println(Easy409().longestPalindrome("abccccdd"))
    println(Easy409().longestPalindrome("a"))
    println(Easy409().longestPalindrome("bb"))
}