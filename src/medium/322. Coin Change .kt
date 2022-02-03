package medium

import BFSTopic
import DynamicProgrammingTopic

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */

class Medium322 : DynamicProgrammingTopic, BFSTopic {

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dd = IntArray(amount + 1) { Int.MAX_VALUE }
        dd[0] = 0
        for (i in 1 until dd.size) {
            for (coin in coins) {
                if (coin <= i && dd[i - coin] != Int.MAX_VALUE) {
                    dd[i] = minOf(dd[i - coin] + 1, dd[i])
                }
            }
        }
        return if (dd[amount] == Int.MAX_VALUE) -1 else dd[amount]
    }
}

fun main() {
    println(Medium322().coinChange(intArrayOf(1, 2, 5), 11))
    println(Medium322().coinChange(intArrayOf(2), 3))
    println(Medium322().coinChange(intArrayOf(1), 0))
}