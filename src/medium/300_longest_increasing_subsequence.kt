package medium

class Solution300 {

    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty())
            return 0
        var result = 1
        val dp = IntArray(nums.size)
        dp[0] = 1
        for (i in 1 until nums.size) {
            var max = 0
            for (j in 0 until i) {
                if (nums[i] > nums[j] && dp[j] > max)
                    max = dp[j]
            }
            dp[i] = max + 1
            result = Math.max(result, dp[i])
        }
        return result
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}