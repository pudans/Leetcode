package medium

import DynamicProgrammingTopic


/**
 * 790. Domino and Tromino Tiling
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 *
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
In a tiling, every square must be covered by a tile.
Two tilings are different if and only if there are two 4-directionally adjacent cells on the board
such that exactly one of the tilings has both squares occupied by a tile.

 BULLSHIT
 */

class Medium790 : DynamicProgrammingTopic {

    private var f_cache = HashMap<Int, Long>()
    private var p_cache = HashMap<Int, Long>()

    fun numTilings(n: Int): Int {
        p_cache[2] = 1L
        f_cache[1] = 1L
        f_cache[2] = 2L
        return f(n).toInt()
    }

    private fun f(k: Int): Long {
        if (f_cache.containsKey(k)) return f_cache[k]!!
        val result = (f(k - 1) + f(k - 2) + 2 * p(k - 1)) % 1000000007
        f_cache[k] = result
        return result
    }

    private fun p(k: Int): Long {
        if (p_cache.containsKey(k)) return p_cache[k]!!
        val result = (p(k - 1) + f(k - 2)) % 1000000007
        p_cache[k] = result
        return result
    }
}

fun main() {
    println(Medium790().numTilings(3))
    println(Medium790().numTilings(1))
    println(Medium790().numTilings(60))
    println(Medium790().numTilings(30))
}