package medium

import ArraysTopic

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */

class Medium238 : ArraysTopic {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = 1
        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        val cache = IntArray(nums.size)
        cache[nums.size - 1] = 1
        for (i in (nums.size - 2) downTo 0) {
            cache[i] = cache[i + 1] * nums[i + 1]
        }

        for (i in nums.indices) {
            result[i] = result[i] * cache[i]
        }

        return result
    }
}