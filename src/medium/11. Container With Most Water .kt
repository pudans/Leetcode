package medium

import ArraysTopic
import GreedyTopic
import TwoPointersTopic

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines,
 * which, together with the x-axis forms a container, such that the container contains the most water.
 * Notice that you may not slant the container.
 */

class Medium11: ArraysTopic, TwoPointersTopic, GreedyTopic {

    fun maxArea(height: IntArray): Int {
        var result = 0
        for (i in 0 until height.size - 1) {
            for (j in i + 1 until height.size) {
                val res = Math.min(height[i],height[j]) * (j - i)
                if (res > result) {
                    result = res
                }
            }
        }
        return result
    }
}

fun main() {
    println(Medium11().maxArea(intArrayOf(1,1)))
    println(Medium11().maxArea(intArrayOf(4,3,2,1,4)))
    println(Medium11().maxArea(intArrayOf(1,2,1)))
}