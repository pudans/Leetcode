package easy

/**
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return true if n is an ugly number.
 */

class Easy263 {

    fun isUgly(num: Int): Boolean =
        when {
            num <= 0 -> false
            num == 1 -> true
            num % 2 == 0 -> isUgly(num / 2)
            num % 3 == 0 -> isUgly(num / 3)
            num % 5 == 0 -> isUgly(num / 5)
            else -> false
    }
}

fun main() {
    for (i in 1 .. 100) {
        println("$i = ${Easy263().isUgly(i)}")
    }
}