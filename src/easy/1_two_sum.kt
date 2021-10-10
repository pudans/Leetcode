package easy

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 */

class Solution1 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size - 1) {
            for (j in (i + 1) until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    println(Solution1().twoSum(nums = intArrayOf(2,7,11,15), target = 9).toList())
    println(Solution1().twoSum(nums = intArrayOf(3,2,4), target = 6).toList())
    println(Solution1().twoSum(nums = intArrayOf(3,3), target = 6).toList())
}