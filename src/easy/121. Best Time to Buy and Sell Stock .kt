package easy

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

class Easy121 {

    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var min = Int.MAX_VALUE
        var profit = 0
        prices.forEach {
            if (it < min) {
                if (result < profit) {
                    result = profit
                }
                profit = 0
                min = it
            } else {
                if (it - min > profit) {
                    profit = it - min
                }
            }
        }
        if (profit > result) {
            result = profit
        }
        return result
    }
}

fun main() {
    println(Easy121().maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(Easy121().maxProfit(intArrayOf(7,6,4,3,1)))
}