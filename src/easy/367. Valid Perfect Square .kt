package easy

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Follow up: Do not use any built-in library function such as sqrt.
 */

class Easy367 {

    fun isPerfectSquare(num: Int): Boolean =
        mySqrt(num) % 1 == 0.0

    private fun mySqrt(x: Int): Double {
        if (x == 0) return 0.0
        var last = 0.0
        var res = 1.0
        while (res != last) {
            last = res
            res = (res + x / res) / 2
        }
        return res
    }
}

fun main() {
    println(Easy367().isPerfectSquare(16))
    println(Easy367().isPerfectSquare(14))
}