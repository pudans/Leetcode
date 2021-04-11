package medium

import kotlin.collections.ArrayList

class Solution46 {

    fun permute(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        generate(result, nums, 0, nums.size)
        return result
    }

    fun generate(result: ArrayList<List<Int>>, nums: IntArray, l: Int, r: Int) {
        if (l == r) {
            result.add(nums.toList())
            // println("${result.size} ${nums.toList()}")
            return
        } else {
            var temp = 0
            for (i in l until r) {
                temp = nums[l]
                nums[l] = nums[i]
                nums[i] = temp

                generate(result, nums, l+1, r)

                temp = nums[l]
                nums[l] = nums[i]
                nums[i] = temp
            }
        }
    }
}