package medium

class Solution494 {

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        if (nums.size == 0) {
            return 0
        }
        return findTargetSumWays(nums, target, 0, 0)
    }

    fun findTargetSumWays(nums: IntArray, target: Int, result: Int, position: Int): Int {

        if (position == nums.size - 1) {
            var dd = 0
            if (result - nums[position] == target) {
                dd++
            }
            if (result + nums[position] == target) {
                dd++
            }
            return dd
        } else {
            return findTargetSumWays(nums, target, result + nums[position], position + 1) +
                    findTargetSumWays(nums, target, result - nums[position], position + 1)
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution494().findTargetSumWays(intArrayOf(1,1,1,1,1), 3)
            println(dd)
        }
    }
}