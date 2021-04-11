package medium

class Solution279 {

    /**
     * Bullshit
     */

    fun numSquares(n: Int): Int {
        if (n <= 3)
            return n
        val dp = IntArray(n + 1)
        for (i in 1..n) {
            dp[i] = Int.MAX_VALUE
            var j = 1
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1)
                j++
            }
            println(dp[i])
        }
        return dp[n]
    }
}