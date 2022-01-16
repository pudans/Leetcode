package easy

import BitManipulationTopic

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * BULLSHIT
 */

class Easy191 : BitManipulationTopic {

    fun hammingWeight(n: Int): Int {
        var input: Long = if (n < 0) 2L * Int.MAX_VALUE + 2L + n else n.toLong()
        var result = 0
        var pow = 31
        while (input != 0L || pow >= 0) {
            val h = Math.pow(2.0, pow.toDouble()).toLong()
            if (input >= h) {
                input -= h
                result++
            }
            pow -= 1
        }
        return result
    }
}