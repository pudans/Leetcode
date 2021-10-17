package easy

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */

class Easy350 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) return intArrayOf()
        val result = mutableListOf<Int>()
        val large = if (nums1.size >= nums2.size) nums1 else nums2
        val small = if (nums1.size >= nums2.size) nums2 else nums1
        val dd = small.toMutableList()
        large.forEach { a ->
            for (i in dd.indices) {
                if (a == dd[i]) {
                    result.add(a)
                    dd.removeAt(i)
                    break
                }
            }
        }
        return result.toIntArray()
    }
}

fun main() {
    println(Easy350().intersect(intArrayOf(1,2,2,1), intArrayOf(2,2)).toList())
    println(Easy350().intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).toList())

}