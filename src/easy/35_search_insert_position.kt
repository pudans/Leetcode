package easy

class Solution35 {

    fun searchInsert(nums: IntArray, target: Int): Int {

        var result = 0
        for (i in nums.indices) {
            if (nums[i] == target) {
                return i
            }
            if  (nums[i] < target) {
                result = i + 1
            }
            if (nums[i] > target) {
                break
            }
        }
        return result
    }
}