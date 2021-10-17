package easy

import ArraysTopic
import MathTopic

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */

class Easy66: ArraysTopic, MathTopic {

    fun plusOne(digits: IntArray): IntArray {
        var index = digits.size - 1
        while (true) {
            if (digits[index] == 9) {
                digits[index] = 0
                if (index == 0) {
                    return IntArray(digits.size + 1) { ii ->
                        if (ii == 0) 1 else 0
                    }
                } else {
                    index--
                }
            } else if (digits[index] <= 9) {
                digits[index]++
                return digits
            } else {
                digits[index] = 0
                return digits
            }
        }
    }
}

fun main() {
    println(Easy66().plusOne(intArrayOf(1,2,3)).toList())
    println(Easy66().plusOne(intArrayOf(4,3,2,1)).toList())
    println(Easy66().plusOne(intArrayOf(0)).toList())
    println(Easy66().plusOne(intArrayOf(9)).toList())
}