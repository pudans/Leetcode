package easy

import ArraysTopic
import GreedyTopic

/**
 * 605. Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/
 *
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 */

class Easy605 : ArraysTopic, GreedyTopic {

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var result = 0
        for (i in flowerbed.indices step 2) {
            val start = i == 0 || flowerbed[i - 1] == 0
            val end = i == flowerbed.lastIndex || flowerbed[i + 1] == 0
            if (start && end && flowerbed[i] == 0) result++
            if (result >= n) return true
        }
        // edge case
        if (flowerbed.size % 2 == 0
            && flowerbed.size > 3
            && flowerbed.last() == 0
            && flowerbed[flowerbed.size - 2] == 0
            && flowerbed[flowerbed.size - 3] == 1
        ) result++
        return result >= n
    }
}

fun main() {
    println(Easy605().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    println(Easy605().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
    println(Easy605().canPlaceFlowers(intArrayOf(0, 0, 0, 0, 0, 1, 0, 0), 0))
    println(Easy605().canPlaceFlowers(intArrayOf(0, 1, 0, 1, 0, 1, 0, 0), 1))
}