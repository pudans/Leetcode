package easy

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 */

class Easy448 {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = IntArray(nums.size) { it + 1 }
        nums.forEach { result[it - 1] = -1 }
        return result.filter { it > 0 }
    }
}

fun main() {
    println(Easy448().findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1)))
    println(Easy448().findDisappearedNumbers(intArrayOf(1,1)))
}