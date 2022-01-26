package medium

import StackTopic
import StringTopic
import java.util.*


/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 */

class Medium1249 : StringTopic, StackTopic {

    fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Int>()
        val set = HashSet<Int>()
        s.forEachIndexed { i, ch ->
            if (ch == '(') {
                stack.push(i)
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    set.add(i)
                } else {
                    stack.pop()
                }
            }
        }
        set.addAll(stack)
        val sb = StringBuilder()
        for (i in s.indices) {
            if (!set.contains(i)) {
                sb.append(s[i])
            }
        }
        return sb.toString()
    }
}

fun main() {
    println(Medium1249().minRemoveToMakeValid("lee(t(c)o)de)"))
    println(Medium1249().minRemoveToMakeValid("a)b(c)d"))
    println(Medium1249().minRemoveToMakeValid("))(("))
}