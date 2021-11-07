package medium

import StackTopic
import java.util.*

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */

class Medium739 : StackTopic {

    fun dailyTemperatures(array: IntArray): IntArray {
        val result = IntArray(array.size)
        val stack = PriorityQueue<Pair<Int,Int>> { o1, o2 -> o1.second - o2.second }
        stack.offer(Pair(0, array[0]))
        for (i in 1 until array.size) {
            while (stack.peek() != null && stack.peek().second < array[i]) {
                val dd = stack.poll()
                result[dd.first] = i - dd.first
            }
            stack.offer(Pair(i, array[i]))
            println(stack.string())
        }
        return result
    }
}

fun main() {
    val data = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    println(Medium739().dailyTemperatures(data).toList())
}

fun PriorityQueue<*>.string(): String {
    val str = StringBuilder()
    val dd = PriorityQueue(this)
    while (dd.peek() != null) {
        str.append(dd.poll()).append(", ")
    }
    return str.toString()
}