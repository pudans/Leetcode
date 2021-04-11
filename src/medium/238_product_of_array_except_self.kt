package medium

class Solution238 {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = 1
        for (i in 1 until nums.size) {
            result[i] = result[i-1] * nums[i-1]
        }

        val cache = IntArray(nums.size)
        cache[nums.size - 1] = 1
        for (i in (nums.size - 2) downTo 0) {
            cache[i] = cache[i+1] * nums[i+1]
        }

        for (i in nums.indices) {
            result[i] = result[i] * cache[i]
        }

        return result
    }
}