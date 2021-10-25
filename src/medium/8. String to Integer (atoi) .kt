package medium

import StringTopic

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either.
 * This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
 * Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range.
 * Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */

class Medium8: StringTopic {

    fun myAtoi(str: String): Int {
        val newStr = str.trim()
        if (newStr.isEmpty()) return 0
        var isMinus = false
        var result = 0L
        when {
            newStr[0] == '-' -> isMinus = true
            newStr[0] == '+' -> isMinus = false
            newStr[0].isDigit() -> result = newStr[0].toString().toLong()
            else -> return 0
        }
        for (i in 1 until newStr.length) {
            if (newStr[i].isDigit()) {
                result = (result * 10) + newStr[i].toString().toInt()
                if (isMinus && -result < Int.MIN_VALUE ) {
                    return Int.MIN_VALUE
                } else if (result > Int.MAX_VALUE) {
                    return Int.MAX_VALUE
                }

            } else {
                return if (isMinus) {
                    -result.toInt()
                } else {
                    result.toInt()
                }
            }
        }
        return if (isMinus) {
            -result.toInt()
        } else {
            result.toInt()
        }
    }
}

fun main() {
    println(Medium8().myAtoi("42"))
    println(Medium8().myAtoi("   -42"))
    println(Medium8().myAtoi("4193 with words"))
    println(Medium8().myAtoi("words and 987"))
    println(Medium8().myAtoi("-91283472332"))
}