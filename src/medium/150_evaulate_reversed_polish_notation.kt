package medium

import java.util.*

class Solution150 {

    val singns = arrayOf("-","+","*","/")
    lateinit var data: LinkedList<String>

    fun evalRPN(tokens: Array<String>): Int {
        data = LinkedList(tokens.toList())
        while (data.size > 1) {
            findAndEvaluate()
        }
        return Integer.parseInt(data.first)
    }

    private fun findAndEvaluate() {
        val index = data.indexOfFirst { singns.contains(it) }
        val first = Integer.parseInt(data.getOrNull(index - 2))
        val second = Integer.parseInt(data.getOrNull(index - 1))
        val result = when (data.get(index)) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            else -> first / second
        }
        data.set(index-2, result.toString())
        data.removeAt(index-1)
        data.removeAt(index-1)
    }
}