package easy

/**
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */

class Easy485 {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var currResult = 0

        nums.forEach {
            if (it == 1) {
                currResult++
            } else {
                if (currResult > result) {
                    result = currResult
                }
                currResult = 0
            }
        }
        if (currResult > result) {
            result = currResult
        }
        return result
    }
}

fun main() {
    println(Easy485().findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
    println(Easy485().findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1)))
}