package easy

class Solution350 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) {
            return intArrayOf()
        }
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

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val data1 = intArrayOf(1,2,2,1)
            val data2 = intArrayOf(2,2)
            println(Solution350().intersect(data1, data2).toList())
        }
    }
}