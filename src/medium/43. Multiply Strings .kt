package medium

import MathTopic

/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/combination-sum/
 *
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

class Medium43 : MathTopic {

    fun multiply(num1: String, num2: String): String {
        if (num1.isEmpty() || num2.isEmpty() || "0" == num1 || "0" == num2) return "0"
        if ("1" == num1) return num2
        if ("1" == num2) return num1

        val result = IntArray(num1.length + num2.length)
        for (i in num1.lastIndex downTo 0) {
            for (j in num2.lastIndex downTo 0) {
                var product = (num1[i] - '0') * (num2[j] - '0')
                product += result[i + j + 1]
                result[i + j + 1] = product % 10
                result[i + j] += product / 10
            }
        }

        val sb = StringBuilder()
        for (r in result) {
            if (sb.isEmpty() && r == 0) {
                continue
            }
            sb.append(r)
        }
        return sb.toString()
    }
}

fun main() {
    println(Medium43().multiply("2", "3"))
    println(Medium43().multiply("123", "456"))
}