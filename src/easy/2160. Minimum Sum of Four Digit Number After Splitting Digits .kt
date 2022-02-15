package easy

import ArraysTopic
import TwoPointersTopic

/**
 * 2160. Minimum Sum of Four Digit Number After Splitting Digits
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 *
You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2 by using the digits found in num.
Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3.
Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
Return the minimum possible sum of new1 and new2.
 */

class Easy2160 : ArraysTopic, TwoPointersTopic {

    fun minimumSum(num: Int): Int {
        val nums = num.toString().toCharArray().map { it - '0' }.sorted()
        var n1 = 0
        var n2 = 0
        for (i in nums.indices) {
            if (i % 2 == 0) {
                n1 = n1 * 10 + nums[i]
            } else {
                n2 = n2 * 10 + nums[i]
            }
        }
        return n1 + n2
    }
}

fun main() {
    println(Easy2160().minimumSum(2932))
    println(Easy2160().minimumSum(4009))
}