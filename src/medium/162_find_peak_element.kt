package medium

class Solution162 {

    fun findPeakElement(nums: IntArray): Int {
        for (i in nums.indices) {
            val prev = if (i == 0) true else nums[i] > nums[i-1]
            val next = if (i == nums.size - 1) true else nums[i] > nums[i+1]

            if (prev && next) {
                return i
            }
        }
        return -1
    }
}