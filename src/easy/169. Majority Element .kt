package easy

import SortingTopic

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */

class Easy169 : SortingTopic {

    fun majorityElement(nums: IntArray): Int = nums.sortedArray()[nums.size / 2]

    fun majorityElement1(nums: IntArray): Int {
        var maxCount = 0
        var maxValue = 0
        val map = HashMap<Int, Int>()
        nums.forEach {
            val value = map.getOrDefault(it, 0) + 1
            map[it] = value
            if (value > maxCount) {
                maxCount = value
                maxValue = it
            }
        }
        return maxValue
    }
}

fun main() {
    println(Easy169().majorityElement(intArrayOf(3, 2, 3)))
    println(Easy169().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}