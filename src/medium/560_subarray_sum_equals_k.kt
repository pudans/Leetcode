package medium

class Solution560 {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var result = 0
        for (i in nums.indices) {
            var dd = 0
            for (j in i until nums.size) {
                dd += nums[j]
                if (dd == k) {
                    result++
                }
            }
        }
        return result
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution560().subarraySum(intArrayOf(1,2,3), 3)
            println(dd)
        }
    }
}