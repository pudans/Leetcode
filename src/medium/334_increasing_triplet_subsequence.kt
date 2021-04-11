package medium

import java.util.*

class Solution334 {

    fun increasingTriplet(nums: IntArray): Boolean {
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE
        for (num in nums) {
            when {
                num <= first -> first = num
                num <= second -> second = num
                else -> return true
            }
        }
        return false
    }

    // Mine
    fun increasingTriplet2(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }

        for (i in 0 until nums.size  - 2) {
            for (j in i until nums.size  - 1) {
                for (z in j until nums.size) {
                    if (nums[i] < nums[j] && nums[j] < nums[z]) {
                        return true
                    }
                }
            }
        }
        return false
    }
}