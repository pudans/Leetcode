package easy

class Solution268 {
    fun missingNumber(nums: IntArray): Int {
        var result = nums.size
        for (i in nums.indices) {
            result = result + i - nums[i]
        }
        return result
    }
}