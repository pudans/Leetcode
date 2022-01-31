package easy

import ArraysTopic
import MatrixTopic

/**
 * 1672. Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/
 *
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
 */

class Easy1672 : ArraysTopic, MatrixTopic {

    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.maxOf { it.sum() }
//        return accounts.map { it.sum() }.max() ?: 0
    }
}

fun main() {
    println(Easy1672().maximumWealth(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))))
    println(Easy1672().maximumWealth(arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))))

}