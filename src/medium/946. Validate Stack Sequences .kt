package medium

import ArraysTopic
import StackTopic
import java.util.*

/**
 * 946. Validate Stack Sequences
 * https://leetcode.com/problems/validate-stack-sequences/
 *
Given two integer arrays pushed and popped each with distinct values,
return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 */

class Medium946 : ArraysTopic, StackTopic {

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var i = 0
        var j = 0
        while (i < pushed.size || j < popped.size) {
            if (stack.isEmpty()) {
                if (i < pushed.size) {
                    stack.push(pushed[i])
                    i++
                } else return false
            } else {
                if (j < popped.size) {
                    if (popped[j] == stack.peek()) {
                        stack.pop()
                        j++
                    } else {
                        if (i < pushed.size) {
                            stack.push(pushed[i])
                            i++
                        } else return false
                    }
                } else return false
            }
        }
        return true
    }
}

fun main() {
    println(Medium946().validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(Medium946().validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))

}