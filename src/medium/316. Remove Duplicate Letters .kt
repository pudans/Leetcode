package medium

import GreedyTopic
import StackTopic
import StringTopic
import java.util.*

/**
 * 316. Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
Given a string s, remove duplicate letters so that every letter appears once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.
 BULLSHIT
 */

class Medium316 : StringTopic, StackTopic, GreedyTopic {

    fun removeDuplicateLetters(s: String): String {
        val stack = Stack<Char>()
        val freq = IntArray(26)
        val seen = BooleanArray(26)
        for (element in s) { freq[element - 'a']++ }
        for (element in s) {
            freq[element - 'a']--
            if (seen[element - 'a']) continue
            while (stack.size > 0 && stack.peek() > element && freq[stack.peek() - 'a'] > 0) {
                seen[stack.pop() - 'a'] = false
            }
            stack.push(element)
            seen[element - 'a'] = true
        }
        return stack.joinToString("")
    }
}

fun main() {
    println(Medium316().removeDuplicateLetters("bcabc"))
    println(Medium316().removeDuplicateLetters("cbacdcbc"))
}