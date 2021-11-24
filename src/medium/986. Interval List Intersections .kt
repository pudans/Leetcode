package medium

import ArraysTopic
import TwoPointersTopic


/**
 * 986. Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/
 *
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 */

class Medium986: ArraysTopic, TwoPointersTopic {

    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val ans: MutableList<IntArray> = ArrayList()
        var i = 0
        var j = 0
        while (i < A.size && j < B.size) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            val lo = Math.max(A[i][0], B[j][0])
            val hi = Math.min(A[i][1], B[j][1])
            if (lo <= hi) ans.add(intArrayOf(lo, hi))

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1]) i++ else j++
        }
        return ans.toTypedArray()
    }

}

fun main() {
    println(Medium986().intervalIntersection(
            arrayOf(intArrayOf(0,2), intArrayOf(5,10), intArrayOf(13,23), intArrayOf(24,25)),
            arrayOf(intArrayOf(1,5), intArrayOf(8,12), intArrayOf(15,24), intArrayOf(25,26))
            ).toList().map { it.toList() })
}