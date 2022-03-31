package hard

import ArraysTopic
import BinarySearchTopic
import DynamicProgrammingTopic
import GreedyTopic


/**
 * 410. Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/
 *
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.
 BULLSHIT
 */

class Hard410 : ArraysTopic, BinarySearchTopic, DynamicProgrammingTopic, GreedyTopic {

    var memo = Array<Array<Int?>>(1001) { arrayOfNulls(51) }

    private fun getMinimumLargestSplitSum(prefixSum: IntArray, currIndex: Int, subarrayCount: Int): Int {
        val n = prefixSum.size - 1

        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][subarrayCount] != null) {
            return memo[currIndex][subarrayCount]!!
        }

        // Base Case: If there is only one subarray left, then all of the remaining numbers
        // must go in the current subarray. So return the sum of the remaining numbers.
        if (subarrayCount == 1) {
            return prefixSum[n] - prefixSum[currIndex].also { memo[currIndex][subarrayCount] = it }
        }

        // Otherwise, use the recurrence relation to determine the minimum largest subarray
        // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
        var minimumLargestSplitSum = Int.MAX_VALUE
        for (i in currIndex..n - subarrayCount) {
            // Store the sum of the first subarray.
            val firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex]

            // Find the maximum subarray sum for the current first split.
            val largestSplitSum = Math.max(
                firstSplitSum,
                getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1)
            )

            // Find the minimum among all possible combinations.
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum)
            if (firstSplitSum >= minimumLargestSplitSum) {
                break
            }
        }
        return minimumLargestSplitSum.also { memo[currIndex][subarrayCount] = it }
    }

    fun splitArray(nums: IntArray, m: Int): Int {
        // Store the prefix sum of nums array.
        val n = nums.size
        val prefixSum = IntArray(n + 1)
        for (i in 0 until n) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]
        }
        return getMinimumLargestSplitSum(prefixSum, 0, m)
    }
}