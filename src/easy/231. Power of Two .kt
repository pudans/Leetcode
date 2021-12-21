package easy

import MathTopic

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

class Easy231 : MathTopic {

    fun isPowerOfTwo(n: Int): Boolean =
        when {
            n <= 0 -> false
            n <= 2 -> true
            n % 2 == 1 -> false
            else -> isPowerOfTwo(n / 2)
        }
}

fun main() {
    println(Easy231().isPowerOfTwo(1))
    println(Easy231().isPowerOfTwo(16))
    println(Easy231().isPowerOfTwo(3))
    println(Easy231().isPowerOfTwo(4))
    println(Easy231().isPowerOfTwo(5))
}