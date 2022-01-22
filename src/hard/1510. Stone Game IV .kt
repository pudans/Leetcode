package hard

import DynamicProgrammingTopic
import MathTopic


/**
 * 1510. Stone Game IV
 * https://leetcode.com/problems/cherry-pickup-ii/
 *
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.
Also, if a player cannot make a move, he/she loses the game.
Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.

BULLSHIT
 */

class Hard1510 : MathTopic, DynamicProgrammingTopic {

    fun winnerSquareGame(n: Int): Boolean {
        val cache = HashMap<Int, Boolean>()
        cache[0] = false
        return dfs(cache, n)
    }

    fun dfs(cache: HashMap<Int, Boolean>, remain: Int): Boolean {
        if (cache.containsKey(remain)) {
            return cache[remain]!!
        }
        val sqrt_root = Math.sqrt(remain.toDouble()).toInt()
        for (i in 1..sqrt_root) {
            // if there is any chance to make the opponent lose the game in the next round,
            // then the current player will win.
            if (!dfs(cache, remain - i * i)) {
                cache[remain] = true
                return true
            }
        }
        cache[remain] = false
        return false
    }
}

fun main() {
    println(Hard1510().winnerSquareGame(1))
    println(Hard1510().winnerSquareGame(2))
    println(Hard1510().winnerSquareGame(4))
}