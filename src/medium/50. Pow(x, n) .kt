package medium

import MathTopic
import RecursionTopic

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

class Medium50: MathTopic, RecursionTopic {

    fun myPow(x: Double, n: Int): Double {
        val result = pow(x, Math.abs(n).toLong())
        return if (n < 0) 1 / result else result
    }

    private fun pow(x: Double, n: Long): Double =
        if (n == 0L) {
            1.0
        } else if (n % 2L == 0L) {
            val s = pow(x, n / 2)
            s * s
        } else {
            x * pow(x, n - 1)
        }
}

fun main() {
    println(Medium50().myPow(2.0, 10))
    println(Medium50().myPow(2.1, 3))
    println(Medium50().myPow(2.0, -2))
}