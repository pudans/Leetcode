package easy

/**
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/
 *
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 */

class Easy414 {

    fun thirdMax(nums: IntArray): Int {
        val result = arrayOfNulls<Int>(3)
        nums.forEach {
            when {
                it == result[0] -> Unit
                result[0] == null || it > result[0]!! -> {
                    result[2] = result[1]
                    result[1] = result[0]
                    result[0] = it
                }
                it == result[1] -> Unit
                result[1] == null || it > result[1]!! -> {
                    result[2] = result[1]
                    result[1] = it
                }
                result[2] == null || it > result[2]!! -> {
                    result[2] = it
                }
            }
        }
        return if (result[2] != null) result[2]!! else result[0]!!
    }
}

fun main() {
    println(Easy414().thirdMax(intArrayOf(3,2,1)))
    println(Easy414().thirdMax(intArrayOf(1,2)))
    println(Easy414().thirdMax(intArrayOf(2,2,3,1)))
}