package easy

class Solution88 {

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