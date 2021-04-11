package medium

class Solution34 {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val index = nums.binarySearch(target)
        if (index < 0) {
            return intArrayOf(-1,-1)
        }
        println(index)
        var start = index
        var end = index
        while (start > 0) {
            if (nums[start - 1] == target) {
                start--
            } else {
                break
            }
        }
        while (end < nums.size - 1) {
            if (nums[end + 1] == target) {
                end++
            } else {
                break
            }
        }
        return intArrayOf(start, end)
    }
}