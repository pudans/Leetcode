package easy

import ArraysTopic
import TwoPointersTopic

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

class Easy88: ArraysTopic, TwoPointersTopic {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val stub = nums1.clone()

        var i = 0
        var j = 0
        nums1.forEachIndexed { index, value ->
            if (i < m && j < n) {
                if (stub[i] > nums2[j]) {
                    nums1[index] = nums2[j]
                    j++
                } else {
                    nums1[index] = stub[i]
                    i++
                }
            } else if (j == n) {
                nums1[index] = stub[i]
                i++
            } else {
                nums1[index] = nums2[j]
                j++
            }
        }
    }
}

fun main() {
    val num1 = intArrayOf(1,2,3,0,0,0)
    Easy88().merge(num1, 3, intArrayOf(2,5,6), 3)
    println(num1.toList())

    val num2 = intArrayOf(1)
    Easy88().merge(num2, 1, intArrayOf(), 0)
    println(num2.toList())

    val num3 = intArrayOf(0)
    Easy88().merge(num3, 0, intArrayOf(1), 1)
    println(num3.toList())
}