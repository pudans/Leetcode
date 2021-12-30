package medium

import HashTableTopic
import MathTopic

/**
 * 1015. Smallest Integer Divisible by K
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 *
Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k,
and n only contains the digit 1.
Return the length of n. If there is no such n, return -1.
Note: n may not fit in a 64-bit signed integer.
 */

class Medium1015 : HashTableTopic, MathTopic {

    fun smallestRepunitDivByK(k: Int): Int {
        if (k % 2 == 0) return -1
        val map = HashSet<Int>()

        var m = 1
        var result = 1

        while (true) {
            m %= k
            if (m == 0) return result
            if (map.contains(m)) return -1
            map.add(m)
            m = m * 10 + 1
            result++
        }
    }
}

fun main() {
    println(Medium1015().smallestRepunitDivByK(1))
    println(Medium1015().smallestRepunitDivByK(2))
    println(Medium1015().smallestRepunitDivByK(3))
    println(Medium1015().smallestRepunitDivByK(5))

}