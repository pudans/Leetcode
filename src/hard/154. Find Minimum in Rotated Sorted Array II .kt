package hard

import BinarySearchTopic


/**
 * 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,4,4,5,6,7] might become:
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * You must decrease the overall operation steps as much as possible.
 */

class Hard154: BinarySearchTopic {

    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        if (nums.size == 1) return nums.first()

        var fromIndex = 0
        var toIndex = nums.size - 1

        while (fromIndex < toIndex) {
            val mid = fromIndex + (toIndex - fromIndex) / 2
            when {
                nums[mid] > nums[toIndex] -> fromIndex = mid + 1
                nums[mid] < nums[toIndex] -> toIndex = mid
                else -> toIndex--
            }
        }
        return nums[toIndex]
    }
}

fun main() {
    println(Hard154().findMin(intArrayOf(1,3,5)))
    println(Hard154().findMin(intArrayOf(2,2,2,0,1)))
    println(Hard154().findMin(intArrayOf(10,1,10,10,10)))
}