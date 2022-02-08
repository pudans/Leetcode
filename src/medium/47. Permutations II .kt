package medium

import ArraysTopic
import BacktrackingTopic

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */

class Medium47 : ArraysTopic, BacktrackingTopic {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = HashSet<List<Int>>()
        generate(result, nums, 0, nums.size)
        return result.toList()
    }

    private fun generate(result: HashSet<List<Int>>, nums: IntArray, l: Int, r: Int) {
        if (l == r) {
            result.add(nums.toList())
        } else {
            var temp = 0
            for (i in l until r) {
                temp = nums[l]
                nums[l] = nums[i]
                nums[i] = temp

                generate(result, nums, l + 1, r)

                temp = nums[l]
                nums[l] = nums[i]
                nums[i] = temp
            }
        }
    }
}

fun main() {
    println(Medium47().permuteUnique(intArrayOf(1, 2, 3)))
    println(Medium47().permuteUnique(intArrayOf(1, 1, 2)))
    println(Medium47().permuteUnique(intArrayOf(0, 1)))
    println(Medium47().permuteUnique(intArrayOf(1)))
}