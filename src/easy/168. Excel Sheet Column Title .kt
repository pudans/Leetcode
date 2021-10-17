package easy

import java.lang.StringBuilder

/**
 * 168. Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 */

class Easy168 {

    val data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    fun convertToTitle(num: Int): String {
        var dd = num
        val result = StringBuilder()
        while (dd > 26) {
            var bb = dd / 26
            val ff = dd - (bb * 26)
            result.append(if (ff == 0) {
                bb--
                data.last()
            } else {
                data[ff - 1]
            })
            dd = bb
        }
        result.append(data[dd - 1])
        return result.toString().reversed()
    }
}

fun main() {
    println(Easy168().convertToTitle(1))
    println(Easy168().convertToTitle(28))
    println(Easy168().convertToTitle(701))
    println(Easy168().convertToTitle(2147483647))
    println(Easy168().convertToTitle(2000000000))
}