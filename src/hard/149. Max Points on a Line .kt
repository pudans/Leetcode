package hard

import ArraysTopic
import HashTableTopic
import MathTopic


/**
 * 149. Max Points on a Line
 * https://leetcode.com/problems/max-points-on-a-line/
 *
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.
 */

class Hard149 : ArraysTopic, HashTableTopic, MathTopic {

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size < 3) return points.size
        val array = ArrayList<ArrayList<IntArray>>()
        for (i in 0 until points.size - 1) {
            val p1 = points[i]
            for (j in (i + 1) until points.size) {
                val p2 = points[j]
                val list1 = ArrayList<IntArray>().apply {
                    add(p1)
                    add(p2)
                }
                array.add(list1)
            }
        }
        for (i in array.indices) {
            val list = array[i]
            val p1 = list[0]
            val p2 = list[1]
            for (element in points) {
                val p3 = element
                if (p1[0] == p3[0] && p1[1] == p3[1]) continue
                if (p2[0] == p3[0] && p2[1] == p3[1]) continue
                if (collinear(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1])) {
                    list.add(p3)
                }
            }
        }
        return array.maxOf { it.size }
//        return array.map { it.size }.max() ?: 0
    }

    private fun collinear(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Boolean =
        (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)
}

fun main() {
    println(Hard149().maxPoints(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))))
    println(
        Hard149().maxPoints(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(3, 2),
                intArrayOf(5, 3),
                intArrayOf(4, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 4)
            )
        )
    )
}