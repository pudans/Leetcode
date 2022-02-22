package easy

import MathTopic
import StringTopic

/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
 */

class Easy171 : MathTopic, StringTopic {

    fun titleToNumber(s: String): Int {
        var result = 0
        for (i in s.lastIndex downTo 0) {
            result += Math.pow(26.toDouble(), (s.lastIndex - i).toDouble()).toInt() * (s[i].toInt() - 64)
        }
        return result
    }
}

fun main() {
    println(Easy171().titleToNumber("A"))
    println(Easy171().titleToNumber("AB"))
    println(Easy171().titleToNumber("ZY"))
    println(Easy171().titleToNumber("FXSHRXW"))
}