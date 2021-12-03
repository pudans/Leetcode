package medium

import ArraysTopic
import DynamicProgrammingTopic


/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.
 */

class Medium152 : ArraysTopic, DynamicProgrammingTopic {

    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        val dpPos = IntArray(nums.size)
        val dpNeg = IntArray(nums.size)
        var max = nums[0]
        dpPos[0] = nums.first()
        dpNeg[0] = nums.first()

        for (i in 1 until nums.size) {
            dpPos[i] = when {
                nums[i] > 0 -> maxOf(nums[i], dpPos[i - 1] * nums[i])
                else -> dpNeg[i - 1] * nums[i]
            }
            dpNeg[i] = when {
                nums[i] > 0 -> dpNeg[i - 1] * nums[i]
                else -> minOf(nums[i], dpPos[i - 1] * nums[i])
            }
            max = maxOf(dpPos[i], max)
        }
        return max
    }

    fun maxProduct1(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        var result = Int.MIN_VALUE
        for (i in 0 until nums.size - 1) {
            var curResult = nums[i]
            if (curResult > result) {
                result = curResult
            }
            for (j in (i + 1) until nums.size) {
                if (nums[j] > result) {
                    result = nums[j]
                }
                if (curResult == 0) {
                    break
                }
                curResult *= nums[j]
                if (curResult > result) {
                    result = curResult
                }
                // println("$i $j $curResult")
            }
        }
        return result
    }
}

fun main() {
    println(Medium152().maxProduct(intArrayOf(2,3,-2,4)))
    println(Medium152().maxProduct(intArrayOf(-2,0,-1)))
    println(Medium152().maxProduct(intArrayOf(2,-1,1,1)))

}