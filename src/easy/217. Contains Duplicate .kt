package easy

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

class Easy217 {

    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach {
            when (set.contains(it)) {
                true -> return true
                false -> set.add(it)
            }
        }
        return false
    }
}

fun main() {
    println(Easy217().containsDuplicate(intArrayOf(1,2,3,1)))
    println(Easy217().containsDuplicate(intArrayOf(1,2,3,4)))
    println(Easy217().containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}