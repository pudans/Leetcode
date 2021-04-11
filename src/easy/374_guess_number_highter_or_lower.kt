package easy

abstract class GuessGame {

    fun guess(num:Int): Int = when {
        num > 3 -> -1
        num < 3 -> 1
        else -> 0
    }

    abstract fun guessNumber(n:Int):Int
}

class Solution374: GuessGame() {

    override fun guessNumber(n:Int): Int {
        return findInRange(1,n)
    }

    fun findInRange(start: Int, end: Int): Int {
        if (start >= end) {
            return start
        } else {
            if (guess(start) == 0) {
                return start
            }

            if (guess(end) == 0) {
                return end
            }

            val mid = ((start.toLong() + end.toLong()) / 2L).toInt()
            val result = guess(mid)
             println("$mid $result $start $end")

            return when(result) {
                -1 -> findInRange(start, mid - 1)
                1 -> findInRange(mid + 1, end)
                else -> mid
            }
        }
    }
}

object Main374 {

    @JvmStatic
    fun main(args: Array<String>) {
        val dd = Solution374()
        println(dd.guessNumber(4))
    }
}