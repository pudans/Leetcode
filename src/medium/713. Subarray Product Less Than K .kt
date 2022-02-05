package medium

import ArraysTopic
import SlidingWindowTopic


/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
Given an array of integers nums and an integer k,
return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 BULLSHIT
 */

class Medium713 : ArraysTopic, SlidingWindowTopic {

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0
        var prod = 1
        var ans = 0
        var left = 0
        for (right in nums.indices) {
            prod *= nums[right]
            while (prod >= k) prod /= nums[left++]
            ans += right - left + 1
        }
        return ans
    }

    // mine
    fun numSubarrayProductLessThanK1(nums: IntArray, k: Int): Int {
        if (k == 0) return 0
        if (nums.size == 1) return if (nums.first() < k) 1 else 0
        var result = 0
        for (size in 1 ..nums.size) {
            var window = 1
            for (z in 0 until size) {
                window *= nums[z]
            }
            if (window < k) result++
            for (i in 1..(nums.size - size)) {
                window /= nums[i - 1]
                window *= nums[i - 1 + size]
                if (window < k) result++
            }
        }
        return result
    }
}

fun main() {
    println(Medium713().numSubarrayProductLessThanK(intArrayOf(10, 5, 2, 6), 100))
//    println(Medium713().numSubarrayProductLessThanK(intArrayOf(1, 2, 3), 0))

}