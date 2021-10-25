package easy

import StackTopic
import java.util.*

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */

class Easy155: StackTopic {

    class MinStack {

        private val mValueState = Stack<Int>()
        private val mMinStack = Stack<Int>()

        fun push(x: Int) {
            mValueState.push(x)
            if (mMinStack.isEmpty() || x <= mMinStack.peek()) {
                mMinStack.push(x)
            }
        }

        fun pop() {
            val value = mValueState.pop() ?: return
            if (mMinStack.isNotEmpty() && mMinStack.peek() == value) {
                mMinStack.pop()
            }
        }

        fun top(): Int = mValueState.peek()

        fun getMin(): Int = mMinStack.peek()
    }
}

fun main() {
    val stack = Easy155.MinStack()
    stack.push(5)
    stack.push(7)
    stack.push(2)
    println(stack.getMin())
    stack.pop()
    println(stack.top())
    println(stack.getMin())
}