package easy

import DynamicProgrammingTopic

/**
 * 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.
 */

class Easy1137 : DynamicProgrammingTopic {

    val mem = HashMap<Int, Int>()

    fun tribonacci(n: Int): Int =
        when {
            n == 0 -> 0
            n == 1 -> 1
            n == 2 -> 1
            mem.containsKey(n) -> mem[n]!!
            else -> {
                val result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
                mem[n] = result
                result
            }
        }
}

fun main() {
    println(Easy1137().tribonacci(25))
    println(Easy1137().tribonacci(3))
    println(Easy1137().tribonacci(4))
}