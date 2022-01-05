package medium

import ArraysTopic
import BacktrackingTopic
import java.util.*


/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 *
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.

BULLSHIT
 */

class Medium77 : ArraysTopic, BacktrackingTopic {

    fun combine(n: Int, k: Int): List<List<Int>> {
        val output: MutableList<List<Int>> = ArrayList()
        val queue = LinkedList<List<Int>>()
        for (i in 1..n) {
            val l = ArrayList<Int>()
            l.add(i)
            queue.add(l)
        }
        while (!queue.isEmpty()) {
            val list = queue.poll()
            if (list.size == k) {
                output.add(list)
            } else {
                val last = list[list.size - 1]
                for (i in last + 1..n) {
                    val newList = ArrayList(list)
                    newList.add(i)
                    queue.add(newList)
                }
            }
        }
        return output
    }
}

fun main() {
    println(Medium77().combine(4, 2))
    println(Medium77().combine(1, 1))
}