package medium

import ArraysTopic
import MathTopic
import StackTopic
import java.util.*

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 */

class Medium150: ArraysTopic, MathTopic, StackTopic {

    private val singns = arrayOf("-","+","*","/")
    private lateinit var data: LinkedList<String>

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
        val result = when (data[index]) {
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

fun main() {
    println(Medium150().evalRPN(arrayOf("2","1","+","3","*")))
    println(Medium150().evalRPN(arrayOf("4","13","5","/","+")))
    println(Medium150().evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))

}