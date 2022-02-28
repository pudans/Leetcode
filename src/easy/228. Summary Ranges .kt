package easy

import ArraysTopic

/**
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 *
You are given a sorted unique integer array nums.
Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:
"a->b" if a != b
"a" if a == b
 */

class Easy228 : ArraysTopic {

    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()
        if (nums.size == 1) return listOf(nums.first().toString())
        val result = ArrayList<String>()
        var start = nums.first()
        var end = nums.first()
        fun addResult(newStart: Int) {
            if (start == end) {
                result.add(start.toString())
            } else {
                result.add("$start->$end")
            }
            start = nums[newStart]
            end = nums[newStart]
        }
        for (i in 1 until nums.size) {
            if (nums[i] - nums[i - 1] == 1) {
                end = nums[i]
            } else {
                addResult(i)
            }
        }
        addResult(0)
        return result
    }
}

fun main() {
    println(Easy228().summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)))
    println(Easy228().summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)))
}