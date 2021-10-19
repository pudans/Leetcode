package easy

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 *
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */

class Easy496 {

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray =
        IntArray(nums1.size) { position ->
            val target = nums1[position]
            var found = false
            for (i in nums2.indices) {
                if (nums2[i] == target) {
                    found = true
                }
                if (nums2[i] > target && found) {
                    return@IntArray nums2[i]
                }
            }
            return@IntArray -1
        }
}

fun main() {
    println(Easy496().nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2)).toList())
    println(Easy496().nextGreaterElement(intArrayOf(2,4), intArrayOf(1,2,3,4)).toList())
}