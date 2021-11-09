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
        val result = StringBuilder()
        var number = 0
        var i = 0
        while (i < str.length) {
            when {
                str[i].isDigit() && number != 0 -> number = number * 10 + (str[i] - '0')
                str[i].isDigit() -> number = str[i] - '0'
                str[i] == '[' -> {
                    val closeBreak = findCloseBreak(i + 1, str)
                    val detekt = decodeString(str.substring(i + 1, closeBreak))
                    for (j in 1..number) {
                        result.append(detekt)
                    }
                    i = closeBreak
                    number = 0
                }
                else -> result.append(str[i])
            }
            i++
        }

        return result.toString()
    }

    private fun findCloseBreak(start: Int, str: String): Int {
        var opened = 0
        for (i in start until str.length) {
            when {
                str[i] == '[' -> opened++
                str[i] == ']' && opened != 0 -> opened--
                str[i] == ']' -> return i
            }
        }
        return -1
    }
}

fun main() {
    println(Medium394().decodeString("3[a]2[bc]"))
    println(Medium394().decodeString("3[a2[c]]"))
    println(Medium394().decodeString("2[abc]3[cd]ef"))
    println(Medium394().decodeString("abc3[cd]xyz"))
}