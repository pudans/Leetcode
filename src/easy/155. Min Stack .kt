package easy

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

class MinStack: Stack<Int>() {

    private val mMinStack = Stack<Int>()

    override fun push(x: Int): Int? {
        if (mMinStack.isEmpty() || x <= mMinStack.peek()) {
            mMinStack.push(x)
        }
        return super.push(x)
    }

    override fun pop(): Int? {
        val value = super.pop()
        if (mMinStack.isNotEmpty() && mMinStack.peek() == value) {
            mMinStack.pop()
        }
        return value
    }

    fun top(): Int = super.peek()

    fun getMin(): Int {
        if (isEmpty()) {
            throw EmptyStackException()
        }
        return mMinStack.peek()
    }

}