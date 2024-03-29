package easy

import HashTableTopic
import MathTopic
import TwoPointersTopic

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 *
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */

class Easy202 : HashTableTopic, MathTopic, TwoPointersTopic {

    fun isHappy(n: Int): Boolean {
        if (n == 1) return true
        var param = n
        repeat(10) {
            param = param.toString().sumBy { char -> Character.getNumericValue(char).let { it * it } }
            if (param == 1) return true
        }
        return false
    }
}

fun main() {
    println(Easy202().isHappy(19))
    println(Easy202().isHappy(2))
}