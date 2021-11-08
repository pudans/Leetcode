package medium

import HashTableTopic

/**
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */

class Medium525 : HashTableTopic {

    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int,Int>()
        map[0] = -1
        var result = 0
        var count = 0
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (map.containsKey(count)) {
                result = Math.max(result, i - map[count]!!)
            } else {
                map[count] = i
            }
        }
        return result
    }
}

fun main() {
    println(Medium525().findMaxLength(intArrayOf(0,1,0)))
}