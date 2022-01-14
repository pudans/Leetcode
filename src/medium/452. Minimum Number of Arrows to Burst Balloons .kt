package medium

import GreedyTopic
import SortingTopic
import java.util.*

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
There are some spherical balloons taped onto a flat wall that represents the XY-plane.
The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend.
You do not know the exact y-coordinates of the balloons.
Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot.
A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 */

class Medium452 : SortingTopic, GreedyTopic {

    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        var result = 0
        var arrow = 0
        for (i in points.indices) {
            if (result == 0 || points[i][0] > arrow) {
                arrow = points[i][1]
                result++
            }
        }
        return result
    }
}

fun main() {
    println(
        Medium452().findMinArrowShots(
            arrayOf(
                intArrayOf(10, 16),
                intArrayOf(2, 8),
                intArrayOf(1, 6),
                intArrayOf(7, 12)
            )
        )
    )
    println(
        Medium452().findMinArrowShots(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                intArrayOf(5, 6),
                intArrayOf(7, 8)
            )
        )
    )
    println(
        Medium452().findMinArrowShots(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5)
            )
        )
    )
}