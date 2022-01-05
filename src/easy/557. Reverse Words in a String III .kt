package easy

/**
 * 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */

class Easy557 {

    fun reverseWords(s: String): String =
        s.split(" ").joinToString(" ") { it.reversed() }
}

fun main() {
    println(Easy557().reverseWords("Let's take LeetCode contest"))
    println(Easy557().reverseWords("God Ding"))
}