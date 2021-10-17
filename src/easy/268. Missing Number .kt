package easy

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */

class Easy268 {

    fun missingNumber(nums: IntArray): Int =
        nums.size + nums.indices.sumOf { it - nums[it] }
}

fun main() {
    println(Easy268().missingNumber(intArrayOf(3,0,1)))
    println(Easy268().missingNumber(intArrayOf(0,1)))
    println(Easy268().missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))
    println(Easy268().missingNumber(intArrayOf(0)))
}