package medium

import DynamicProgrammingTopic
import MathTopic

/**
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/
 *
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
Return the maximum product you can get.
 */

class Medium343 : DynamicProgrammingTopic, MathTopic {

    fun integerBreak(n: Int): Int {
        if (n == 2) return 1
        if (n == 3) return 2
        return when {
            n % 3 == 0 -> Math.pow(3.0, (n / 3).toDouble()).toInt()
            n % 3 == 1 -> Math.pow(3.0, (n / 3 - 1).toDouble()).toInt() * 4
            else -> Math.pow(3.0, (n / 3).toDouble()).toInt() * 2
        }
    }
}

fun main() {
    println(Medium343().integerBreak(2))
    println(Medium343().integerBreak(10))
}