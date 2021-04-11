package medium

class Solution152 {

    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        var result = Int.MIN_VALUE
        for (i in 0 until nums.size - 1) {
            var curResult = nums[i]
            if (curResult > result) {
                result = curResult
            }
            for (j in (i + 1) until nums.size) {
                if (nums[j] > result) {
                    result = nums[j]
                }
                if (curResult == 0) {
                    break
                }
                curResult *= nums[j]
                if (curResult > result) {
                    result = curResult
                }
                // println("$i $j $curResult")
            }
        }
        return result
    }
}