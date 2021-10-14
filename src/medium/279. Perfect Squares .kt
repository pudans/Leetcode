package medium

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */

class Medium279 {

    fun numSquares(n: Int): Int {
        if (n <= 3) return n
        val dp = IntArray(n + 1)
        for (i in 1..n) {
            if (i <= 3) { dp[i] = i; continue; }
            dp[i] = Int.MAX_VALUE
            var j = 1
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1)
                j++
            }
        }
        return dp[n]
    }
}

fun main() {
    println(Medium279().numSquares(12))
    println(Medium279().numSquares(13))
}