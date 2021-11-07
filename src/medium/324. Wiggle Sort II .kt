package medium

import SortingTopic

/**
 * 324. Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * You may assume the input array always has a valid answer.
 */

class Medium324 : SortingTopic {

    fun wiggleSort(nums: IntArray) {
        val comparator = Comparator<Int> { i1: Int, i2: Int -> i2 - i1 }
        val sorted = nums.sortedWith(comparator)
        for (h in nums.indices) {
            val j = if (h % 2 != 0) h / 2 else (nums.size / 2 + h / 2)
            nums[h] = sorted[j]
        }
    }
}