package hard

import ArraysTopic
import GreedyTopic
import HeapTopic
import java.util.*

/**
 * 1675. Minimize Deviation in Array
 * https://leetcode.com/problems/minimize-deviation-in-array/
 *
You are given an array nums of n positive integers.
You can perform two types of operations on any element of the array any number of times:
If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.
Return the minimum deviation the array can have after performing some number of operations.

BULLSHIT
 */

class Hard1675 : ArraysTopic, GreedyTopic, HeapTopic {

    fun minimumDeviation(nums: IntArray): Int {
        val pq = PriorityQueue(Collections.reverseOrder<Int>())
        var min = Int.MAX_VALUE
        for (i in nums) {
            var m = i
            if (i % 2 == 1) m *= 2
            pq.add(m)
            min = minOf(min, m)
        }
        var diff = Int.MAX_VALUE
        while (pq.peek() % 2 == 0) {
            var max = pq.remove()
            diff = minOf(diff, max - min)
            max /= 2
            min = minOf(min, max)
            pq.add(max)
        }
        return minOf(diff, pq.peek() - min)
    }
}

fun main() {
    println(Hard1675().minimumDeviation(intArrayOf(1, 2, 3, 4)))
    println(Hard1675().minimumDeviation(intArrayOf(4, 1, 5, 20, 3)))
    println(Hard1675().minimumDeviation(intArrayOf(2, 10, 8)))
}