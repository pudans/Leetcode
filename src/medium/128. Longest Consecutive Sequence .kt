package medium


/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */

class Medium128 {

    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var result = 0
        for (num in set) {
            if (!set.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1
                while (set.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                    set.remove(currentNum)
                }
                result = Math.max(result, currentStreak)
            }
        }
        return result
    }
}

fun main() {
    println(Medium128().longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(Medium128().longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
}