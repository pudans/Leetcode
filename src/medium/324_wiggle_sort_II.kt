package medium

class Solution324 {

    fun wiggleSort(nums: IntArray) {
        val comparator = Comparator<Int> { i1: Int, i2: Int -> i2 - i1}
        val sorted = nums.sortedWith(comparator)
        for (h in nums.indices) {
            val j = if (h % 2 != 0) h/2 else (nums.size / 2 + h/2)
            nums[h] = sorted[j]
        }
    }
}