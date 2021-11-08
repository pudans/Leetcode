package medium

import ArraysTopic
import DynamicProgrammingTopic
import GreedyTopic

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */

class Medium122: ArraysTopic, GreedyTopic, DynamicProgrammingTopic {

    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1 until prices.size) {
            result += Math.max(0, prices[i] - prices[i - 1])
        }
        return result
    }
}

fun main() {
    println(Medium122().maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(Medium122().maxProfit(intArrayOf(1,2,3,4,5)))
    println(Medium122().maxProfit(intArrayOf(7,6,4,3,1)))
}