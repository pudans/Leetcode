package medium

import ArraysTopic
import GreedyTopic
import SortingTopic
import TwoPointersTopic

/**
 * 881. Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/
 *
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
 */

class Medium881 : ArraysTopic, TwoPointersTopic, GreedyTopic, SortingTopic {

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var result = 0
        for (i in people.indices) {
            if (people[i] == 0) continue
            for (j in people.lastIndex downTo i + 1) {
                if (people[j] == 0) continue
                if (people[j] + people[i] > limit) continue
                people[j] = 0
                break
            }
            people[i] = 0
            result++
        }
        return result
    }
}

fun main() {
    println(Medium881().numRescueBoats(intArrayOf(1, 2), 3))
    println(Medium881().numRescueBoats(intArrayOf(3, 2, 2, 1), 3))
    println(Medium881().numRescueBoats(intArrayOf(3, 5, 3, 4), 5))
    println(Medium881().numRescueBoats(intArrayOf(5, 1, 4, 2), 6))
}