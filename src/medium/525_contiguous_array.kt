package medium

import java.util.HashMap




class Solution525 {

    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int,Int>()
        map[0] = -1
        var result = 0
        var count = 0
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (map.containsKey(count)) {
                result = Math.max(result, i - map[count]!!)
            } else {
                map[count] = i
            }
        }
        return result
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution525().findMaxLength(intArrayOf(0,1,0)))
        }
    }
}