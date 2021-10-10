package easy

/**
 * 35. Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */

class Solution35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var result = 0
        for (i in nums.indices) {
            when {
                nums[i] > target -> return result
                nums[i] == target -> return i
                nums[i] < target -> result = i + 1
            }
        }
        return result
    }
}

fun main() {
    println(Solution35().searchInsert(nums = intArrayOf(1,3,5,6), target = 5))
    println(Solution35().searchInsert(nums = intArrayOf(1,3,5,6), target = 2))
    println(Solution35().searchInsert(nums = intArrayOf(1,3,5,6), target = 7))
    println(Solution35().searchInsert(nums = intArrayOf(1,3,5,6), target = 0))
    println(Solution35().searchInsert(nums = intArrayOf(1), target = 0))
}