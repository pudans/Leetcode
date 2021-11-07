package medium

import HashTableTopic

/**
 * 442. Find All Duplicates in an Array
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */

class Medium442 : HashTableTopic {

    fun findDuplicates(nums: IntArray): List<Int> {
        val set = HashSet<Int>(nums.toList())
        nums.forEach { if (set.contains(it)) set.remove(it) else set.add(it) }
        return set.toList()
    }

    fun findDuplicates2(nums: IntArray): List<Int> {
        val result = ArrayList<Int>(nums.size)
        nums.forEachIndexed { index, i ->
            val value = Math.abs(i)
            if (nums[value - 1] < 0) result.add(value)
            nums[value - 1] = -nums[value - 1]
        }
        return result
    }
}

fun main() {
    println(Medium442().findDuplicates(intArrayOf(4,3,2,7,8,2,3,1)))
    println(Medium442().findDuplicates(intArrayOf(1,1,2)))
    println(Medium442().findDuplicates(intArrayOf(1)))
}