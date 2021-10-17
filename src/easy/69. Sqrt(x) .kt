package easy

import BinarySearchTopic
import MathTopic

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 *
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */

class Easy69: MathTopic, BinarySearchTopic {

    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        var last = 0.0
        var res = 1.0
        while (res != last) {
            last = res
            res = (res + x / res) / 2
        }
        return res.toInt()
    }
}

fun main() {
    println(Easy69().mySqrt(4))
    println(Easy69().mySqrt(8))
}