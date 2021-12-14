package hard

import BinarySearchTopic
import MathTopic


/**
 * 878. Nth Magical Number
 * https://leetcode.com/problems/nth-magical-number/
 *
A positive integer is magical if it is divisible by either a or b.
Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7.
 */

class Hard878 : MathTopic, BinarySearchTopic {

    fun nthMagicalNumber(n: Int, a: Int, b: Int): Int {
        val l = a / gcd(a, b) * b
        var start = 0L
        var end = n.toLong() * minOf(a,b)
        while (start < end) {
            val mid = start + (end - start) / 2
            // If there are not enough magic numbers below mi...
            if (mid / a + mid / b - mid / l < n) start = mid + 1 else end = mid
        }
        return (start % 1000000007).toInt()
    }

    private fun gcd(x: Int, y: Int): Int = if (x == 0) y else gcd(y % x, x)
}

fun main() {
    println(Hard878().nthMagicalNumber(1, 2, 3))
    println(Hard878().nthMagicalNumber(4, 2, 3))
    println(Hard878().nthMagicalNumber(5, 2, 4))
    println(Hard878().nthMagicalNumber(3, 6, 4))
}