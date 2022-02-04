package medium

import BitManipulationTopic


/**
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 *
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

BULLSHIT
 */

class Medium201 : BitManipulationTopic {

    fun rangeBitwiseAnd(left: Int, right: Int): Int =
        when {
            left == 0 || right == 0 -> 0
            right > left -> rangeBitwiseAnd(left / 2, right / 2) shl 1
            else -> left
        }
}

fun main() {
    println(Medium201().rangeBitwiseAnd(5, 7))
    println(Medium201().rangeBitwiseAnd(0, 0))
    println(Medium201().rangeBitwiseAnd(1, 2147483647))
}