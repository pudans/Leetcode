package easy

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */

class Easy219 {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int,Int>()
        nums.forEachIndexed { index, value ->
            if (map.containsKey(value) && index - map[value]!! <= k) {
                return true
            }
            map[value] = index
        }
        return false
    }
}

fun main() {
    println(Easy219().containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
    println(Easy219().containsNearbyDuplicate(intArrayOf(1,0,1,1), 1))
    println(Easy219().containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
}