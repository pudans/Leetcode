package medium

class Solution33 {

    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) {
            return -1
        }
        if (nums.size == 1) {
            return if (nums[0] == target) 0 else -1;
        }

        var pivot = -1
        for (i in nums.indices) {
            if (nums[i] < nums.getOrNull(i-1) ?: Int.MIN_VALUE) {
                pivot = i
            }
        }

        val result = if (pivot == -1) {
            nums.binarySearch(target)
        } else if (nums[0] <= target) {
            nums.binarySearch(target, 0, pivot + 1)
        } else {
            nums.binarySearch(target, pivot)
        }

        return if (result >= 0) result else -1
    }
}