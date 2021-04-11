package medium

class Solution581 {

    fun findUnsortedSubarray(nums: IntArray): Int {
        val cloned = nums.clone().sortedArray()
        var start = cloned.size
        var end = 0
        for (i in cloned.indices) {
            if (cloned[i] != nums[i]) {
                start = Math.min(start, i)
                end = Math.max(end, i)
            }
        }
        return if (end - start >= 0) end - start + 1 else 0
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution581().findUnsortedSubarray(intArrayOf(2,6,4,8,10,9,15)))
        }
    }
}