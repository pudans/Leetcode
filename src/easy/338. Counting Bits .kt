package easy

import BitManipulationTopic
import DynamicProgrammingTopic

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

class Easy336 : DynamicProgrammingTopic, BitManipulationTopic {

    fun countBits(num: Int): IntArray =
        IntArray(num + 1) { Integer.bitCount(it) }
}

fun main() {
    println(Easy336().countBits(2).toList())
    println(Easy336().countBits(5).toList())
}