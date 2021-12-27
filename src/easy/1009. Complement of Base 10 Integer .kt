package easy

import BitManipulationTopic

/**
 * 1009. Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 *
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer n, return its complement.
 */

class Easy1009 : BitManipulationTopic {

    fun bitwiseComplement(num: Int): Int =
        num.toString(2).toCharArray().map { if (it == '1') '0' else '1' }.joinToString("").toInt(2)
}

fun main() {
    println(Easy1009().bitwiseComplement(7))
    println(Easy1009().bitwiseComplement(10))
}