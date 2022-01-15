package easy

import MathTopic
import StringTopic

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 */

class Easy415 : StringTopic, MathTopic {

    fun addStrings(num1: String, num2: String): String {
        var result = ""
        var addOne = false
        var i = num1.lastIndex
        var j = num2.lastIndex
        while (i >= 0 || j >= 0) {
            var add = Character.getNumericValue(num1.getOrNull(i) ?: '0')
            add += Character.getNumericValue(num2.getOrNull(j) ?: '0')
            if (addOne) add++
            addOne = add >= 10
            add %= 10
            result = "$add$result"
            i--
            j--
        }
        return if (addOne) "1$result" else result
    }
}


fun main() {
    println(Easy415().addStrings("11", "123"))
    println(Easy415().addStrings("456", "77"))
    println(Easy415().addStrings("0", "0"))
}