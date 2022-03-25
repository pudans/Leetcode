package medium

import GreedyTopic
import MathTopic


/**
 * 991. Broken Calculator
 * https://leetcode.com/problems/broken-calculator/
 *
There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
multiply the number on display by 2, or
subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 BULLSHIT
 */

class Medium991 : MathTopic, GreedyTopic {

    fun brokenCalc(startValue: Int, target: Int): Int {
        var value = target
        var ans = 0
        while (value > startValue) {
            ans++
            value = if (value % 2 == 1) value + 1 else value / 2
        }
        return ans + startValue - value
    }
}

fun main() {
    println(Medium991().brokenCalc(2, 3))
    println(Medium991().brokenCalc(5, 8))
    println(Medium991().brokenCalc(3, 10))
}