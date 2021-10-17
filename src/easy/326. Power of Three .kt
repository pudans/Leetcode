package easy

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 */

class Easy326 {

    fun isPowerOfThree(n: Int): Boolean =
        when {
            n > 3 && n % 3 == 0 -> isPowerOfThree(n / 3)
            n > 3 -> false
            else -> n == 3|| n == 1
        }
}

fun main() {
    println(Easy326().isPowerOfThree(27))
    println(Easy326().isPowerOfThree(0))
    println(Easy326().isPowerOfThree(9))
    println(Easy326().isPowerOfThree(45))
}