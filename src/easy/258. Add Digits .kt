package easy

import MathTopic

/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 *
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */

class Easy258 : MathTopic {

    fun addDigits(num: Int): Int {
        var sum = num
        while (sum > 9) {
            sum = sum.toString().sumBy { it.toInt() - 48 }
        }
        return sum
    }
}

fun main() {
    println(Easy258().addDigits(38))
    println(Easy258().addDigits(0))
}