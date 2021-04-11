package medium

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

class Solution56 {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf(intArrayOf())
        }
        if (intervals.size == 1) {
            return intervals
        }
        intervals.sortBy { it[0] }
        val stack = Stack<IntArray>()
        stack.add(intervals[0])

        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= stack.peek()[1]) {
                val temp = stack.pop()
                temp[1] = Math.max(temp[1], intervals[i][1])
                stack.push(temp)
            } else {
                stack.push(intervals[i])
            }
        }

        return stack.reversed().toTypedArray()
    }

    fun merge2(intervals: Array<IntArray>): Array<IntArray> {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        val line = HashMap<Int, Boolean>()

        intervals.forEach {
            for (i in it[0]..it[1]) {
                if (i < min) min = i
                if (i > max) max = i
                line[i] = true
            }
        }

        val result = ArrayList<IntArray>()
        var openedInterval: IntArray? = null
        for (i in min..max) {
            println("$i ${line[i]} $openedInterval")
            if (line[i] == true) {
                if (openedInterval == null) {
                    openedInterval = intArrayOf(i, 0)
                }
            } else {
                if (openedInterval != null) {
                    openedInterval[1] = i - 1
                    result.add(openedInterval)
                    openedInterval = null
                }
            }
        }
        if (openedInterval != null) {
            openedInterval[1] = max
            result.add(openedInterval)
        }
        return result.toTypedArray()
    }

    fun merge3(intervals: Array<IntArray>): Array<IntArray> {
        val result = ArrayList<IntArray>()
        if (intervals.isEmpty()) {
            return result.toTypedArray()
        }
        result.add(intervals[0])
        if (intervals.size == 1) {
            return result.toTypedArray()
        }

        for (i in 1 until intervals.size) {
            val new = intervals[i]
            var find = false
            for (j in 0 until result.size) {
                val value = result[j]
                if (value[0] <= new[0] && value[1] >= new[1]) {
                    find = true
                    break
                } else if ((new[0] <= value[1] && new[0] >= value[0]) ||
                        (new[1] >= value[0] && new[1] <= value[1]) ||
                        (new[0] <= value[0] && new[1] >= value[1])
                ) {
                    val dd = intArrayOf(
                            min(new[0], value[0]),
                            max(new[1], value[1])
                    )
                    println("set $j ${dd.toList()}}")
                    result.set(j, dd)
                    find = true
                    break
                }
            }
            if (!find) {
                println("add ${new.toList()}}")

                result.add(new)
            }
        }
        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val s = Solution56()
    println(s.merge(arrayOf(intArrayOf(0,1), intArrayOf(1,2))).toList())
}