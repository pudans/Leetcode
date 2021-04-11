package easy

class Solution189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        val clone = nums.clone()
        for (i in nums.indices) {
            nums[(i+k)%nums.size] = clone[i]
        }
    }
}