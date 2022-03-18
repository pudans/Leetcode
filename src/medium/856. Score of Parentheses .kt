package medium

import StackTopic
import StringTopic
import java.util.*


/**
 * 856. Score of Parentheses
 * https://leetcode.com/problems/score-of-parentheses/
 *
Given a balanced parentheses string s, return the score of the string.
The score of a balanced parentheses string is based on the following rule:
"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 BULLSHIT
 */

class Medium856 : StringTopic, StackTopic {

    fun scoreOfParentheses(s: String): Int {
        val stack = Stack<Int>()
        stack.push(0)
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.push(0)
            } else {
                val v = stack.pop()
                val w = stack.pop()
                stack.push(w + maxOf(2 * v, 1))
            }
        }
        return stack.pop()
    }
}

fun main() {
    println(Medium856().scoreOfParentheses("()"))
    println(Medium856().scoreOfParentheses("(())"))
    println(Medium856().scoreOfParentheses("()()"))
    println(Medium856().scoreOfParentheses("(()(()))"))
}