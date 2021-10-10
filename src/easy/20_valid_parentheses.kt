package easy

import java.util.*

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 */

class Solution20 {

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length % 2 != 0) return false
        val stack = Stack<Char>()
        s.forEach {
            when {
                isClosed(it) && stack.isEmpty() -> return false
                isClosed(it) -> if (stack.pop() != it) return false
                else -> stack.push(getClosed(it))
            }
        }
        return stack.isEmpty()
    }

    private fun isClosed(ch: Char): Boolean =
        ch == '}' || ch == ']' || ch == ')'

    private fun getClosed(ch: Char): Char =
        when (ch) {
            '[' -> ']'
            '{' -> '}'
            else -> ')'
        }
}

fun main(args: Array<String>) {
    println(Solution20().isValid("()"))
    println(Solution20().isValid("()[]{}"))
    println(Solution20().isValid("(]"))
    println(Solution20().isValid("([)]"))
    println(Solution20().isValid("{[]}"))
}