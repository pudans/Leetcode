package easy

abstract class GuessGame {

    var target = 3

    fun guess(num:Int): Int = when {
        num > target -> -1
        num < target -> 1
        else -> 0
    }

    abstract fun guessNumber(n:Int):Int
}

/**
 * 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * You call a pre-defined API int guess(int num), which returns 3 possible results:
 *
 * -1: The number I picked is lower than your guess (i.e. pick < num).
 * 1: The number I picked is higher than your guess (i.e. pick > num).
 * 0: The number I picked is equal to your guess (i.e. pick == num).
 * Return the number that I picked.
 */

class Easy374: GuessGame() {

    override fun guessNumber(n:Int): Int = findInRange(1,n)

    fun findInRange(start: Int, end: Int): Int =
        when {
            start >= end -> start
//            guess(start) == 0 -> start
//            guess(end) == 0 -> end
            else -> {
                val mid = start / 2 + end / 2
                when(guess(mid)) {
                    -1 -> findInRange(start, mid - 1)
                    1 -> findInRange(mid + 1, end)
                    else -> mid
                }
            }
        }
}

fun main() {
    test(10, 6)
    test(1, 1)
    test(2,1)
    test(2, 2)
    test(4, 3)
    test(30, 4)
}

fun test(n: Int, pick: Int) {
    val d1 = Easy374()
    d1.target = pick
    println(d1.guessNumber(n))
}