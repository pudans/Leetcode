package medium

import kotlin.math.abs

class Solution29 {

    fun divide(dividend: Int, divisor: Int): Int {
        return when (divisor) {
            -1 -> if (dividend == Integer.MIN_VALUE) Integer.MAX_VALUE; else -dividend
            1 -> dividend
            Integer.MIN_VALUE -> if (dividend == Integer.MIN_VALUE) 1 else 0
            else -> {
                val signPos = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)
                var dividend1 = -abs(dividend)
                val divisor1 = -abs(divisor)

                var result = 0
                while (dividend1 <= divisor1) {
                    dividend1 -= divisor1
                    result++
                }
                return if (signPos) result else -result
            }
        }
    }
}