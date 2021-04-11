package easy

class Solution26 {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) {
            return 1
        }
        var result = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i-1]) {
                nums[result] = nums[i]
                result++
            }
        }
        // println(nums.toList())
        return result
    }
}