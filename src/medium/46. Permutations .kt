package medium

import ArraysTopic
import BacktrackingTopic

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

class Medium46: ArraysTopic, BacktrackingTopic {

    fun permute(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        generate(result, nums, 0, nums.size)
        return result
    }

    fun generate(result: ArrayList<List<Int>>, nums: IntArray, l: Int, r: Int) {
        if (l == r) {
            result.add(nums.toList())
            return
        } else {
            var temp = 0
            for (i in l until r) {
                temp = nums[l]
                nums[l] = nums[i]
                nums[i] = temp

                generate(result, nums, l+1, r)

                temp = nums[l]
                nums[l] = nums[i]
                nums[i] = temp
            }
        }
    }
}

fun main() {
    println(Medium46().permute(intArrayOf(1,2,3)))
    println(Medium46().permute(intArrayOf(0,1)))
    println(Medium46().permute(intArrayOf(1)))
}