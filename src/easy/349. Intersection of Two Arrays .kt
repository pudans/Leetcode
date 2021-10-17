package easy

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */

class Easy349 {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val result = HashSet<Int>()
        val set1 = HashSet<Int>()
        val set2 = HashSet<Int>()
        for (i in 0 until Math.max(nums1.size,nums2.size)) {
            if (i < nums1.size) {
                set1.add(nums1[i])
                if (set2.contains(nums1[i])) {
                    result.add(nums1[i])
                }
            }
            if (i < nums2.size) {
                set2.add(nums2[i])
                if (set1.contains(nums2[i])) {
                    result.add(nums2[i])
                }
            }
        }
        return result.toIntArray()
    }
}

fun main() {
    println(Easy349().intersection(intArrayOf(1,2,2,1), intArrayOf(2,2)).toList())
    println(Easy349().intersection(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).toList())
}