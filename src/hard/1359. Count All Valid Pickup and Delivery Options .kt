package hard

import CombinatoricsTopic
import DynamicProgrammingTopic
import MathTopic

/**
 * 1359. Count All Valid Pickup and Delivery Options
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 *
Given n orders, each order consist in pickup and delivery services.
Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
Since the answer may be too large, return it modulo 10^9 + 7.

BULLSHIT
 */

class Hard1359 : MathTopic, DynamicProgrammingTopic, CombinatoricsTopic {

    private val MOD = 1000000007L
    private lateinit var memo: Array<LongArray>

    private fun totalWays(unpicked: Int, undelivered: Int): Long {
        if (unpicked == 0 && undelivered == 0) {
            // We have completed all orders.
            return 1
        }
        if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
            // We can't pick or deliver more than N items
            // Number of deliveries can't exceed number of pickups
            // as we can only deliver after a pickup.
            return 0
        }
        if (memo[unpicked][undelivered] != 0L) {
            // Return cached value, if already present.
            return memo[unpicked][undelivered]
        }
        var ans: Long = 0

        // Count all choices of picking up an order.
        ans += unpicked * totalWays(unpicked - 1, undelivered)
        // Handle integer overflow.
        ans %= MOD

        // Count all choices of delivering a picked order.
        ans += (undelivered - unpicked) * totalWays(unpicked, undelivered - 1)
        // Handle integer overflow.
        ans %= MOD
        return ans.also { memo[unpicked][undelivered] = it }
    }

    fun countOrders(n: Int): Int {
        memo = Array(n + 1) { LongArray(n + 1) }
        return totalWays(n, n).toInt()
    }
}

fun main() {
    println(Hard1359().countOrders(1))
    println(Hard1359().countOrders(2))
    println(Hard1359().countOrders(3))
}