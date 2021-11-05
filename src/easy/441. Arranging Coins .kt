package easy

/**
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 *
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 * Given the integer n, return the number of complete rows of the staircase you will build.
 */

class Easy441 {

    fun arrangeCoins(n: Int, level: Int = 1): Int {
        if (n < level) return level - 1
        return arrangeCoins(n - level, level + 1)
    }
}


fun main() {
    println(Easy441().arrangeCoins(5))
    println(Easy441().arrangeCoins(23))
    println(Easy441().arrangeCoins(50))
}