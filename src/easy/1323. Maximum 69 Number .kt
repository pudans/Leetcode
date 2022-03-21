package easy

import GreedyTopic
import MathTopic

/**
 * 1323. Maximum 69 Number
 * https://leetcode.com/problems/maximum-69-number/
 *
You are given a positive integer num consisting only of digits 6 and 9.
Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 */

class Easy1323 : MathTopic, GreedyTopic {

    fun maximum69Number(num: Int): Int {
        val arr = num.toString().toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '6') {
                arr[i] = '9'
                return String(arr).toInt()
            }
        }
        return num
    }
}

fun main() {
    println(Easy1323().maximum69Number(9669))
    println(Easy1323().maximum69Number(9996))
    println(Easy1323().maximum69Number(9999))
}