package easy

class Solution349 {

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