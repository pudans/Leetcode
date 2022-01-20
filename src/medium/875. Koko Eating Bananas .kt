package medium

import ArraysTopic
import BinarySearchTopic


/**
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */

class Medium875 : ArraysTopic, BinarySearchTopic {

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
//        val max = piles.maxBy { it } ?: 0
        val max = piles.maxOf { it }
        if (piles.size == h) return max
        var start = 1
        var end = max
        while (start < end) {
            var hh = 0
            val middle = (start + end) / 2
            for (i in piles.indices) {
                hh += piles[i] / middle
                hh += if (piles[i] % middle >= 1) 1 else 0
            }
            when (hh <= h) {
                true -> end = middle
                false -> start = middle + 1
            }
        }
        return end
    }
}

fun main() {
    println(Medium875().minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    println(Medium875().minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
    println(Medium875().minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))

}