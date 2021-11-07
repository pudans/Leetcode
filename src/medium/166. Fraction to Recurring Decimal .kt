package medium

import HashTableTopic
import MathTopic
import StringTopic

/**
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * If multiple answers are possible, return any of them.
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */

class Medium166 : HashTableTopic, MathTopic, StringTopic {

    fun fractionToDecimal(numerator: Int, denominator: Int): String? {
        val negtive = numerator / denominator.toFloat() < 0f
        var num = Math.abs(numerator.toLong())
        val deno = Math.abs(denominator.toLong())
        val result = if (negtive) {
            "-".plus(num / deno)
        } else {
            (num / deno).toString()
        }
        if (num % deno == 0L) {
            return result
        }

        var decimal = ""
        num = num % deno * 10
        val mods: HashMap<Long, Int> = HashMap()
        var index = 0
        while (!mods.containsKey(num) && num != 0L) {
            mods[num] = index++
            decimal += num / deno
            num = num % deno * 10
        }
        if (num == 0L) return "$result.$decimal"
        val i = mods[num]!!
        return "$result.${decimal.substring(0, i)}(${decimal.substring(i)})"
    }
}