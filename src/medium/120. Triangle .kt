package medium

import ArraysTopic
import DynamicProgrammingTopic
import GreedyTopic
import TwoPointersTopic

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 *
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */

class Medium120: ArraysTopic, DynamicProgrammingTopic {

    val mem = mutableListOf<IntArray>()

    fun minimumTotal(triangle: List<List<Int>>, level: Int = 0, pos: Int = 0): Int {
        if (level == triangle.lastIndex) return triangle[level][pos]
        val list = triangle[level]
        if (mem.size == level) mem.add(IntArray(list.size) { Int.MIN_VALUE} )
        if (mem[level][pos] != Int.MIN_VALUE) return mem[level][pos]

        val min = minOf(
            minimumTotal(triangle, level + 1, pos),
            minimumTotal(triangle, level + 1, pos + 1)
        ) + triangle[level][pos]
        mem[level][pos] = min

        return min
    }
}

fun main() {
    println(Medium120().minimumTotal(listOf(listOf(2), listOf(3,4), listOf(6,5,7), listOf(4,1,8,3))))
    println(Medium120().minimumTotal(listOf(listOf(-10))))
}