package easy

import DynamicProgrammingTopic
import MathTopic

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class Easy70: MathTopic, DynamicProgrammingTopic {

    fun climbStairs(n: Int): Int {
        if (n <= 1) return 1
        val array = IntArray(n)
        array[0] = 1
        array[1] = 2
        for (i in 2 until n) {
            array[i] = array[i - 1] + array[i - 2]
        }
        return array.last()
    }
}

fun main() {
    println(Easy70().climbStairs(2))
    println(Easy70().climbStairs(3))
    println(Easy70().climbStairs(14))
}