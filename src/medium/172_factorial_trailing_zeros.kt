package medium

import java.math.BigInteger
class Solution172 {

    fun trailingZeroes(n: Int): Int {
        return if (n == 0) 0 else n / 5 + trailingZeroes(n / 5)
    }

    fun trailingZeroes1(n: Int): Int {
        if (n == 0) {
            return 0
        }

        var result = 0
        if (n > 24) {
            val factorial = factorialBig(BigInteger.valueOf(n.toLong()))
            val factorialString = factorial.toString()
            for (i in (factorialString.length - 1) downTo 0) {
                if (factorialString[i] != '0') {
                    break
                } else {
                    result++
                }
            }
        } else {
            val factorial = factorial(n)
            if (factorial < 10) {
                return 0
            } else {
                var index = 10
                while (true) {
                    if (factorial < index) {
                        break
                    }
                    if (factorial % index == 0L) {
                        result++
                        index *= 10
                    } else {
                        break
                    }
                }

                return result
            }
        }
        return result
    }

    fun factorial(n: Int): Long =
            when(n) {
                1 -> 1
                else -> n * factorial(n - 1)
            }

    fun factorialBig(n: BigInteger): BigInteger =
            when(n) {
                BigInteger.ONE -> BigInteger.ONE
                else -> factorialBig(n - BigInteger.ONE).multiply(n)
            }
}