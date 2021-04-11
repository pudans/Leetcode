package medium

class Solution50 {

    fun myPow(x: Double, n: Int): Double {

        val result = pow(x, Math.abs(n).toLong())
        return if (n < 0) 1/result else result
    }

    fun pow(x: Double, n: Long): Double {
        if (n == 0L) {
            return 1.0
        } else if (n % 2L == 0L) {
            val s = pow(x, n / 2)
            return s * s
        } else {
            return x * pow(x, n - 1)
        }
    }
}