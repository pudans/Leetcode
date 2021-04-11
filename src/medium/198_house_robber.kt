package medium

class Solution198 {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return Math.max(nums[0], nums[1])
        nums[2] += nums[0]
        for (i in 3 until nums.size) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3])
        }
        println(nums.toList())
        return Math.max(nums[nums.size - 1], nums[nums.size - 2])
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution198().rob(intArrayOf(121,48,151,122,147,24,30,61,41,200,244,194,201,147,195,170,80,41,229,46,69,231,40,74,241,151,224,96,132,108,41,244,224,44,14,147,32,5,27,231,77,60,233,31,169,17,169,28,129,157,3,73,139,3,132,133,34,154,101,84,13,134,124,172,239,202,147,8,213,178,193,70,14,212,0,203,237,202,80,140,250,150,144,224)))
        }
    }
}