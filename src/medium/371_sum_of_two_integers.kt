package medium

class Solution371 {
    fun getSum(a: Int, b: Int): Int {
        var result = 0L
        val isA = a >= 0
        val isB = b >= 0
        for (i in 0 until Math.abs(a.toLong())) {
            if (isA) result++ else result--
        }
        for (i in 0 until Math.abs(b.toLong())) {
            if (isB) result++ else result--
        }
        return result.toInt()
    }
}