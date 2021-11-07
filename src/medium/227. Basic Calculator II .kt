package medium

import MathTopic
import StackTopic
import StringTopic

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 */

class Medium227 : StackTopic, MathTopic, StringTopic {

    val numbers = ArrayList<Int>()
    val signs = ArrayList<Char>()

    fun calculate(s: String): Int {
        val str = s.filter { it != ' ' }
        var lastSign = -1
        for (i in str.indices) {
            if (!str[i].isDigit()) {
                signs.add(str[i])
                val num = str.substring(lastSign + 1, i)
                println("$i ${str[i]} $lastSign $num")

                numbers.add(num.toInt())
                lastSign = i
            }
            if (i == s.length - 1) {
                val num = s.substring(lastSign + 1)
                numbers.add(num.toInt())
            }
        }

        var index = signs.indexOfFirst { it == '*' || it == '/' }
        while (index >= 0) {
            go(index)
            index = signs.indexOfFirst { it == '*' || it == '/' }
        }

        while (signs.isNotEmpty()) {
            go(0)
        }
        return numbers[0]
    }

    fun go(index: Int) {
        val sign = signs[index]
        val a = numbers[index]
        val b = numbers[index + 1]
        val result = when(sign) {
            '*' -> a * b
            '/' -> a / b
            '-' -> a - b
            else -> a + b
        }
        numbers[index] = result
        numbers.removeAt(index + 1)
        signs.removeAt(index)
    }
}

fun main() {
    println(Medium227().calculate("3+2*2"))
}