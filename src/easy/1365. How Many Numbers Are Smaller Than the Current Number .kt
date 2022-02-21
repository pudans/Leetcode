package easy

import ArraysTopic
import HashTableTopic
import SortingTopic

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.
 */

class Easy1365 : HashTableTopic, ArraysTopic, SortingTopic {

    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        nums.sortedArray().forEachIndexed { index, num ->
            if (!map.contains(num)) {
                map[num] = index
            }
        }
        return IntArray(nums.size) { map[nums[it]]!! }
    }
}

fun main() {
    println(Easy1365().smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3)).toList())
    println(Easy1365().smallerNumbersThanCurrent(intArrayOf(6, 5, 4, 8)).toList())
    println(Easy1365().smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7)).toList())

}