package easy

import java.util.*

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

    fun top(): Int {
        return super.peek()
    }

    fun getMin(): Int {
        if (isEmpty()) {
            throw EmptyStackException()
        }
        return mMinStack.peek()
    }

}