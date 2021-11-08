package medium

import DynamicProgrammingTopic

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

class Medium309 : DynamicProgrammingTopic {

    lateinit var prices: IntArray
    var len = 0

    fun maxProfit(prices: IntArray): Int {
        this.prices = prices
        len = prices.size
        return maxProfit()
    }

    fun maxProfit(): Int {
        var b0s1prev = 0
        var b0s0 = 0
        var b0s1 = 0
        var b1s0 = 0
        var b1s1 = 0
        for (day in len - 1 downTo 0) {
            b0s1 = Math.max(prices[day] + b0s0, b1s1)
            b0s0 = b1s0
            val b0s1prevmp = b0s1prev - prices[day]
            b1s0 = Math.max(b1s0, b0s1prevmp)
            b1s1 = Math.max(b0s1, b0s1prevmp)
            b0s1prev = b0s1
        }
        return b1s0
    }
}

fun main() {
    println(Medium309().maxProfit(intArrayOf(1, 2, 3, 0, 2)))
    println(Medium309().maxProfit(intArrayOf(1)))
}