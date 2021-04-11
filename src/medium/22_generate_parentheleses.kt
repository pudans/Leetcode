package medium

import java.util.*
import kotlin.collections.ArrayList

class Solution22 {

    private val result = ArrayList<String>()

    fun generateParenthesis(n: Int): List<String?> {
        backtrack("", 0, 0, n)
        return result
    }

    private fun backtrack(cur: String, open: Int, close: Int, max: Int) {
        if (cur.length == max * 2) {
            result.add(cur)
            return
        }
        if (open < max) backtrack("$cur(", open + 1, close, max)
        if (close < open) backtrack("$cur)", open, close + 1, max)
    }
}