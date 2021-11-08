package medium

import ArraysTopic
import MathTopic

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 */

class Medium204 : ArraysTopic, MathTopic {

    fun countPrimes(n: Int): Int {
        val isPrime = BooleanArray(n)
        for (i in 2 until n) {
            isPrime[i] = true
        }

        var i = 2
        while (i * i < n) {
            if (!isPrime[i]) {
                i++
                continue
            }
            var j = i * i
            while (j < n) {
                isPrime[j] = false
                j += i
            }
            i++
        }
        var count = 0
        for (i in 2 until n) {
            if (isPrime[i]) count++
        }
        return count
    }
}