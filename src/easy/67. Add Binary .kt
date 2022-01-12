package easy

import BitManipulationTopic
import MathTopic
import StringTopic

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 *
 * Given two binary strings a and b, return their sum as a binary string.
 */

class Easy67 : MathTopic, StringTopic, BitManipulationTopic {

    fun addBinary(a: String, b: String): String {
        var result = ""
        var increase = false
        var aIndex = a.length - 1
        var bIndex = b.length - 1

        loop@ while (true) {
            when {
                aIndex >= 0 && bIndex >= 0 && a[aIndex] == '1' && b[bIndex] == '1' -> {
                    result = (if (increase) '1' else '0') + result
                    increase = true
                }
                aIndex >= 0 && bIndex >= 0 && a[aIndex] == '0' && b[bIndex] == '0' -> {
                    result = (if (increase) '1' else '0') + result
                    increase = false
                }
                aIndex >= 0 && bIndex >= 0 -> {
                    result = (if (increase) '0' else '1') + result
                }
                aIndex >= 0 -> {
                    if (a[aIndex] == '1') {
                        result = (if (increase) '0' else '1') + result
                    } else {
                        result = (if (increase) '1' else '0') + result
                        increase = false
                    }
                }
                bIndex >= 0 -> {
                    if (b[bIndex] == '1') {
                        result = (if (increase) '0' else '1') + result
                    } else {
                        result = (if (increase) '1' else '0') + result
                        increase = false
                    }
                }
                increase -> {
                    result = "1$result"
                    increase = false
                }
                else -> break@loop
            }
            aIndex--
            bIndex--
        }
        return result
    }
}

fun main() {
    println(Easy67().addBinary("11", "1"))
    println(Easy67().addBinary("1010", "1011"))
}