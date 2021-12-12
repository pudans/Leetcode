package easy

import DynamicProgrammingTopic

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 *
The Fibonacci numbers, commonly denoted F(n) form a sequence,
called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
 */

class Easy509 : DynamicProgrammingTopic {

    fun fib(n: Int): Int =
        when (n <= 1) {
            false -> fib(n - 1) + fib(n - 2)
            true -> n
        }
}

fun main() {
    println(Easy509().fib(2))
    println(Easy509().fib(3))
    println(Easy509().fib(4))
}