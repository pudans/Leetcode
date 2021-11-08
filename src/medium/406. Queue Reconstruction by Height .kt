package medium

import GreedyTopic
import SortingTopic

/**
 * 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 */

class Medium406 : GreedyTopic, SortingTopic {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith { one, two -> if (one[0] == two[0]) one[1] - two[1] else two[0] - one[0] }
        val result = ArrayList<IntArray>()
        for (p in people) {
            result.add(p[1], p)
        }
        return Array(result.size) { result[it] }
    }
}

fun main() {
    val dd = Medium406().reconstructQueue(
            arrayOf(
                    intArrayOf(7, 0),
                    intArrayOf(4, 4),
                    intArrayOf(7, 1),
                    intArrayOf(5, 0),
                    intArrayOf(6, 1),
                    intArrayOf(5, 2),
            )
    )
    val ee = dd.joinToString { it.toList().toString() }
    println(ee)
}