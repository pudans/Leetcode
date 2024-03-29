package medium

import BacktrackingTopic
import DynamicProgrammingTopic
import StringTopic

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

class Medium22 : StringTopic, BacktrackingTopic, DynamicProgrammingTopic {

    fun generateParenthesis(n: Int): List<String?> {
        val result = ArrayList<String>()
        backtrack("", 0, 0, n, result)
        return result
    }

    private fun backtrack(cur: String, open: Int, close: Int, max: Int, result: ArrayList<String>) {
        if (cur.length == max * 2) {
            result.add(cur)
            return
        }
        if (open < max) backtrack("$cur(", open + 1, close, max, result)
        if (close < open) backtrack("$cur)", open, close + 1, max, result)
    }
}

fun main() {
    println(Medium22().generateParenthesis(3))
    println(Medium22().generateParenthesis(1))
}