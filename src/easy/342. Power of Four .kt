package easy

/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 */

class Easy342 {

    fun isPowerOfFour(num: Int): Boolean =
        when {
            num > 4 && num % 4 == 0 -> isPowerOfFour(num / 4)
            num > 4 -> false
            else -> num == 4|| num == 1
        }
}

fun main() {
    println(Easy342().isPowerOfFour(16))
    println(Easy342().isPowerOfFour(5))
    println(Easy342().isPowerOfFour(1))
}