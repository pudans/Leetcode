package easy

import java.util.*

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 *
 * Notes:
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */

class MyStack {

    private val queue: Queue<Int> = LinkedList<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        for (i in 0 until queue.size - 1) {
            queue.add(queue.poll())
        }
        return queue.poll()
    }

    fun top(): Int {
        var removed = 0
        for (i in 0 until queue.size) {
            removed = queue.poll()
            queue.add(removed)
        }
        return removed
    }

    fun empty(): Boolean = queue.isEmpty()

    fun toStringff() {
        println(queue.toString())
    }
}

fun main() {
    val stack = MyStack()
    stack.push(1);
    stack.toStringff()
    stack.push(2);
    stack.toStringff()
    println(stack.top())   // returns 2
    stack.toStringff()
    println(stack.pop())   // returns 2
    stack.toStringff()
    println(stack.empty())
    println(stack.pop())
    println(stack.empty()) // // returns false
}