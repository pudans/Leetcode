package easy

import java.util.*

class Solution20 {

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        if (s.length % 2 != 0) {
            return false
        }
        val stack = Stack<Char>()
        s.forEach {
            if (isClosed(it) && stack.isEmpty()) {
                return false
            } else if (isClosed(it)) {
                val peeked = stack.pop()
                if (peeked != it) {
                    return false
                }
            } else {
                stack.push(getClosed(it))
            }
        }
        return stack.isEmpty()
    }

    fun isOpened(ch: Char): Boolean =
        ch == '{' || ch == '[' || ch == '('

    fun isClosed(ch: Char): Boolean =
        ch == '}' || ch == ']' || ch == ')'

    fun getClosed(ch: Char): Char = when(ch) {
        '[' -> ']'
        '{' -> '}'
        else -> ')'
    }

}