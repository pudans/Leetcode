package medium

import DynamicProgrammingTopic


/**
 * 918. Maximum Sum Circular Subarray
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 BULLSHIT
 */

class Medium918: DynamicProgrammingTopic {

    fun maxSubarraySumCircular2(nums: IntArray): Int {

        var start = nums.size / 2 - 1
        var end = nums.size / 2 - 1
        val count = nums.size * 2 - 1

        var result = Int.MIN_VALUE
        var currMax = 0

        var i = 0
        while (i < count) {
            start = (start + 1) % nums.size
            println(nums[start])
            if (currMax < 0) currMax = 0
            currMax += nums[start]
            result = Math.max(result, currMax)
            i++
        }

        return result
    }

    fun maxSubarraySumCircular(A: IntArray): Int {
        val N = A.size
        var ans = A[0]
        var cur = A[0]
        for (i in 1 until N) {
            cur = A[i] + Math.max(cur, 0)
            ans = Math.max(ans, cur)
        }

        val rightsums = IntArray(N)
        rightsums[N - 1] = A[N - 1]
        for (i in N - 2 downTo 0)
            rightsums[i] = rightsums[i + 1] + A[i]

        val maxright = IntArray(N)
        maxright[N - 1] = A[N - 1]
        for (i in N - 2 downTo 0)
            maxright[i] = Math.max(maxright[i + 1], rightsums[i])
        var leftsum = 0
        for (i in 0 until N - 2) {
            leftsum += A[i]
            ans = Math.max(ans, leftsum + maxright[i + 2])
        }
        return ans
    }
}

fun main() {
    println(Medium918().maxSubarraySumCircular(intArrayOf(1,-2,3,-2)))
    println(Medium918().maxSubarraySumCircular(intArrayOf(5,-3,5)))
    println(Medium918().maxSubarraySumCircular(intArrayOf(3,-1,2,-1)))
    println(Medium918().maxSubarraySumCircular(intArrayOf(3,-2,2,-3)))
    println(Medium918().maxSubarraySumCircular(intArrayOf(-2,-3,-1)))
}