package medium

import BitManipulationTopic

/**
 * 371. Sum of Two Integers
https://leetcode.com/problems/sum-of-two-integers/
Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */

class Medium371 : BitManipulationTopic {

    fun getSum(a: Int, b: Int): Int {
        var result = 0L
        val isA = a >= 0
        val isB = b >= 0
        for (i in 0 until Math.abs(a.toLong())) {
            if (isA) result++ else result--
        }
        for (i in 0 until Math.abs(b.toLong())) {
            if (isB) result++ else result--
        }
        return result.toInt()
    }
}