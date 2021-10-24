package medium

import BitManipulationTopic
import MathTopic
import kotlin.math.abs

/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
 * For this problem, assume that your function returns 231 − 1 when the division result overflows.
 */

class Medium29: MathTopic, BitManipulationTopic {

    fun divide(dividend: Int, divisor: Int): Int =
        when (divisor) {
            -1 -> if (dividend == Integer.MIN_VALUE) Integer.MAX_VALUE; else -dividend
            1 -> dividend
            Integer.MIN_VALUE -> if (dividend == Integer.MIN_VALUE) 1 else 0
            else -> {
                val signPos = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)
                var dividend1 = -abs(dividend)
                val divisor1 = -abs(divisor)
                var result = 0
                while (dividend1 <= divisor1) {
                    dividend1 -= divisor1
                    result++
                }
                if (signPos) result else -result
            }
        }
}

fun main() {
    println(Medium29().divide(10, 3))
    println(Medium29().divide(7, -3))
    println(Medium29().divide(0, 1))
    println(Medium29().divide(1, 1))
}