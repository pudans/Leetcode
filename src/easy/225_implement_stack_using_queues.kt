package easy

import java.util.*

class MyStack {

    val queue: Queue<Int> = LinkedList<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        var removed = 0
        for (i in 0 until queue.size - 1) {
            removed = queue.poll()
            queue.add(removed)
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

    fun empty(): Boolean {
        return queue.isEmpty()
    }

    fun toStringff() {
        println(queue.toString())
    }
}

object Main225 {

    @JvmStatic
    fun main(args: Array<String>) {
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
}