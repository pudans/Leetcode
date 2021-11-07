package medium

import DynamicProgrammingTopic

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal
 */
class Medium416 : DynamicProgrammingTopic {

    /**
     * SHIT
     */

    fun canPartition(nums: IntArray): Boolean {
        var sum = nums.sum()
        if (sum and 1 == 1) return false
        sum = sum shr 1
        val dp = BooleanArray(sum + 1)

        // base case for sum 0 --> always possible
        dp[0] = true
        for (i in 1..nums.size) {
            for (j in sum downTo 1) {
                // Note: here nums[i-1] is because the dp array has 1 extra position at 0th index to represent no elements taken
                if (j - nums[i - 1] >= 0)
                    dp[j] = dp[j] || dp[j - nums[i - 1]]
            }
        }
        return dp[sum]
    }
}

fun main() {
    println(Medium416().canPartition(intArrayOf(1, 5, 11, 5)))

}