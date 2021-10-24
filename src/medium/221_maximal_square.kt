package medium

class Solution221 {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix.first().isEmpty()) return 0
        val dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
        var maxsqlen = 0
        for (i in 1..matrix.size) {
            for (j in 1..matrix[0].size) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1
                    maxsqlen = Math.max(maxsqlen, dp[i][j])
                }
            }
        }
        return maxsqlen * maxsqlen
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Medium222().maximalSquare(
                    arrayOf(
                            charArrayOf('1','0','1','0','0'),
                            charArrayOf('1','0','1','1','1'),
                            charArrayOf('1','1','1','1','1'),
                            charArrayOf('1','0','0','1','0')
                    )
            )
            println(dd)
        }
    }
}