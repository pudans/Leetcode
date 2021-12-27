package medium

import SortingTopic
import java.util.*

/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */

class Medium973 : SortingTopic {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        fun IntArray.len() = this[0] * this[0] + this[1] * this[1]
        points.sortWith(kotlin.Comparator() { o1, o2 -> o1.len() - o2.len() } )
        return Array(k) { points[it] }
    }
}

fun main() {
    println(Medium973().kClosest(arrayOf(intArrayOf(1,3), intArrayOf(-2,2)), 1).toList().map { it.toList() })
    println(Medium973().kClosest(arrayOf(intArrayOf(3,3), intArrayOf(5,-1), intArrayOf(-2,4)), 2).toList().map { it.toList() })
}