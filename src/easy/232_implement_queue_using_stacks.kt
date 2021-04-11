package easy

import java.util.*

class MyQueue {

    /** Initialize your data structure here. */
    val stackInput = Stack<Int>()
    val stackOutput = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        stackInput.add(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (stackOutput.isEmpty()) {
            for (i in 0 until stackInput.size) {
                stackOutput.add(stackInput.pop())
            }
        }
        return stackOutput.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (stackOutput.isEmpty()) {
            for (i in 0 until stackInput.size) {
                stackOutput.add(stackInput.pop())
            }
        }
        return stackOutput.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stackInput.isEmpty() && stackOutput.isEmpty()
    }

}