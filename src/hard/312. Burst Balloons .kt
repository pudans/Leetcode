package hard

import DynamicProgrammingTopic
import java.util.*


/**
 * 312. Burst Balloons
 * https://leetcode.com/problems/burst-balloons/
 *
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums.
You are asked to burst all the balloons.
If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array,
then treat it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.
 */

class Hard312 : DynamicProgrammingTopic {

    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val arr = IntArray(n + 2)
        for (i in 0 until n) {
            arr[i + 1] = nums[i]
        }
        arr[0] = 1
        arr[n + 1] = 1
        val dp = Array(n + 2) { IntArray(n + 2) }
        //  dp[i][j]  -  storing the max coins u can earn in  this interval/subarray
        for (wlen in 1..n) {
            for (left in 1..n - wlen + 1) {
                val right = left + wlen - 1

                // now iterate this window, and give chance to every ballon to burst at last
                for (k in left..right) {
                    dp[left][right] = Math.max(
                        dp[left][right],
                        dp[left][k - 1] + dp[k + 1][right] + arr[k] * arr[left - 1] * arr[right + 1]
                    )
                }
            }
        }
        return dp[1][n] // returning answer stored for orginal size problem
    }

    fun maxCoins1(nums: IntArray): Int {
        val list = nums.toMutableList()
        var result = 0
        while (list.size > 0) {

            var localScore = Int.MIN_VALUE
            var toDelete = -1
            for (i in list.indices) {
                val score = (list.getOrNull(i - 1) ?: 1) * (list.getOrNull(i + 1) ?: 1) * list[i]
                if (score > localScore) {
                    localScore = score
                    toDelete = i
                }
            }
            println("$list $localScore $toDelete")
            result += localScore
            list.removeAt(toDelete)
        }
        return result
    }
}

fun main() {
    println(Hard312().maxCoins(intArrayOf(3, 1, 5, 8)))
//    println(Hard312().maxCoins(intArrayOf(1, 5)))
}