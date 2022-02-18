package medium

import GreedyTopic
import MonotonicStackTopics
import StringTopic
import java.util.*

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 *
Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

BULLSHIT
 */

class Medium402 : StringTopic, GreedyTopic, MonotonicStackTopics {

    fun removeKdigits(num: String, k: Int): String {
        var kk = k
        val stack = Stack<Char>()
        for (c in num.toCharArray()) {
            while (!stack.isEmpty() && kk > 0 && stack.peek() > c) {
                stack.pop()
                kk--
            }
            stack.push(c)
        }
        while (!stack.isEmpty() && kk > 0) {
            stack.pop()
            kk--
        }
        val sb = StringBuilder()
        while (!stack.isEmpty()) {
            sb.append(stack.pop())
        }
        sb.reverse()
        while (sb.length > 1 && sb[0] == '0') {
            sb.deleteCharAt(0)
        }
        return if (sb.isNotEmpty()) sb.toString() else "0"
    }
}

fun main() {
    println(Medium17().letterCombinations("23"))
    println(Medium17().letterCombinations(""))
    println(Medium17().letterCombinations("2"))
}