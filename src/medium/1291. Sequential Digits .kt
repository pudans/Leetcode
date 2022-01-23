package medium

/**
 * 1291. Sequential Digits
 * https://leetcode.com/problems/next-permutation/
 *
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */

class Medium1291 {

    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in low.toString().length..minOf(9, high.toString().length)) {
            val charArray = CharArray(i) { '0' + (it + 1) }
            addNumber(charArray, result, low, high)
        }
        return result
    }

    private fun addNumber(num: CharArray, result: MutableList<Int>, low: Int, high: Int) {
        val digit = String(num).toInt()
        if (digit > high) return
        if (digit >= low) {
            result.add(digit)
        }
        if (num.first() - '0' + num.size == 10) return
        for (i in num.indices) {
            num[i] = '0' + ((num[i] - '0') + 1)
        }
        addNumber(num, result, low, high)
    }
}

fun main() {
    println(Medium1291().sequentialDigits(100, 300))
    println(Medium1291().sequentialDigits(1000, 13000))
    println(Medium1291().sequentialDigits(10, 1000000000))
}