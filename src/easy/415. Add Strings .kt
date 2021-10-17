package easy

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 */

class Easy415 {

    fun addStrings(num1: String, num2: String): String {
        if (num1.isEmpty()) return num2
        if (num2.isEmpty()) return num1
        var result = ""
        var addOne = false
        var i = num1.length - 1
        var j = num2.length - 1
        while (i >= 0 || j >= 0) {

            if (i >= 0 && j >= 0) {
                var add = Character.getNumericValue(num1[i]) + Character.getNumericValue(num2[j])
                if (addOne) {
                    add++
                    addOne = false
                }
                if (add < 10) {
                    result = add.toString() + result
                } else {
                    result = (add % 10).toString() + result
                    addOne = true
                }
                i--
                j--
                continue
            }

            if (i >= 0) {
                var add = Character.getNumericValue(num1[i])
                if (addOne) {
                    add++
                    addOne = false
                }
                if (add < 10) {
                    result = add.toString() + result
                } else {
                    result = (add % 10).toString() + result
                    addOne = true
                }
                i--
                continue
            }

            if (j >= 0) {
                var add = Character.getNumericValue(num2[j])
                if (addOne) {
                    add++
                    addOne = false
                }
                if (add < 10) {
                    result = add.toString() + result
                } else {
                    result = (add % 10).toString() + result
                    addOne = true
                }
                j--
                continue
            }
        }

        if (addOne) {
            result = "1$result"
        }
        return result
    }
}


fun main() {
    println(Easy415().addStrings("11", "123"))
    println(Easy415().addStrings("456", "77"))
    println(Easy415().addStrings("0", "0"))
}