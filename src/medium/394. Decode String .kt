package medium

import StackTopic
import StringTopic

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
For example, there won't be input like 3a or 2[4].
 */

class Medium394 : StackTopic, StringTopic {

    fun decodeString(str: String): String {
        println(str)

        val result = StringBuilder()

        var number = 0
        var i = 0
        while (i < str.length) {
            when {
                str[i].isDigit() && number != 0 -> number = number * 10 + (str[i] - '0')
                str[i].isDigit() -> number = str[i] - '0'
                str[i] == '[' -> {
                    val closeBreak = findCloseBreak(i, str)
                    val substring = str.substring(i + 1, closeBreak)
                    val detekt = decodeString(substring)
                    println("catch! $number $substring $detekt")
                    for (j in 1..number) {
                        result.append(detekt)
                    }
                    i = closeBreak
                    number = 0
                }
                str[i] == ']' -> {
                    println("error asd")
                }
                else -> result.append(str[i])
            }
            i++
        }

        return result.toString()
    }

    fun findCloseBreak(start: Int, str: String): Int {
        var openedBreakes = 0
        for (i in (start + 1) until str.length) {
            when {
                str[i] == '[' -> openedBreakes++
                str[i] == ']' && openedBreakes != 0 -> openedBreakes--
                str[i] == ']' -> return i
            }
        }
        println("error vvv")
        return -1
    }
}

fun main() {
    println(Medium394().decodeString("3[a2[c]]"))
}