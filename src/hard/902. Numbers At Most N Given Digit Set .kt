package hard

import ArraysTopic
import BinarySearchTopic
import DynamicProgrammingTopic
import MathTopic

/**
 * 902. Numbers At Most N Given Digit Set
 * https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 *
Given an array of digits which is sorted in non-decreasing order. You can write numbers using each digits[i] as many times as we want.
For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
Return the number of positive integers that can be generated that are less than or equal to a given integer n.
 */

class Hard902 : ArraysTopic, MathTopic, BinarySearchTopic, DynamicProgrammingTopic {

    fun atMostNGivenDigitSet(digits: Array<String>, n: Int, step: Int = 1, nstr: String = n.toString()): Int {
        return if (nstr.length == step) {
            findBinary(n, digits)
        } else {
            Math.pow(digits.size.toDouble(), step.toDouble()).toInt()+atMostNGivenDigitSet(digits, n, step + 1, nstr)
        }
    }

    private fun findBinary(target: Int, digits: Array<String>): Int {
        val targetR = target.toString().length

        var start = 0
        var end = Math.pow(digits.size.toDouble(), targetR.toDouble()).toInt() - 1

        while (start <= end) {
            val mid = (start + end) / 2
//            println("mid $mid")
            val res = encode(digits, mid, targetR)
            if (res == target.toLong()) return mid + 1
            if (res > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
//        println("start $start")
        return start
    }

    private fun encode(digits: Array<String>, target: Int, targetR: Int): Long {
        val result = Array<String>(targetR) { "" }
        var d = target
        for (i in result.lastIndex downTo 0) {
            result[i] = digits[d % digits.size]
            d /= digits.size
        }
//        println(result.toList())
        return result.joinToString("").toLong()
    }
}

fun main() {
    println(Hard902().atMostNGivenDigitSet(arrayOf("1", "3", "5", "7"), 100)) // 20
    println(Hard902().atMostNGivenDigitSet(arrayOf("1", "4", "9"), 1000000000)) // 29523
    println(Hard902().atMostNGivenDigitSet(arrayOf("7"), 8)) // 1
    println(Hard902().atMostNGivenDigitSet(arrayOf("3", "5"), 4)) // 1
    println(Hard902().atMostNGivenDigitSet(arrayOf("3", "4", "8"), 4)) // 2
    println(Hard902().atMostNGivenDigitSet(arrayOf("5", "7", "8"), 59)) // 6
}