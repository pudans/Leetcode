package medium

import MathTopic

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

class Medium7: MathTopic {

    fun reverse(x: Int): Int =
        try {
            val number = (Math.abs(x)).toString().reversed().toLong()
            when {
                number > Int.MAX_VALUE -> 0
                x < 0 -> -number.toInt()
                else -> number.toInt()
            }
        } catch (e: Exception) {
            0
        }
}

fun main() {
    println(Medium7().reverse(123))
    println(Medium7().reverse(-123))
    println(Medium7().reverse(120))
    println(Medium7().reverse(0))
}