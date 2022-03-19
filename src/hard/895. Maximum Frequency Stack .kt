package hard

import HashTableTopic
import StackTopic
import java.util.*


/**
 * 895. Maximum Frequency Stack
 * https://leetcode.com/problems/maximum-frequency-stack/
 *
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
Implement the FreqStack class:
FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
BULLSHIT
 */

class Hard895 : HashTableTopic, StackTopic {

    class FreqStack {
        var freq: MutableMap<Int, Int> = HashMap()
        var group: MutableMap<Int, Stack<Int>> = HashMap()
        var maxfreq: Int = 0

        fun push(x: Int) {
            val f = freq.getOrDefault(x, 0) + 1
            freq[x] = f
            if (f > maxfreq) maxfreq = f
            group.computeIfAbsent(f) { z: Int -> Stack<Int>() }.push(x)
        }

        fun pop(): Int {
            val x = group[maxfreq]!!.pop()
            freq[x] = freq[x]!! - 1
            if (group[maxfreq]!!.size == 0) maxfreq--
            return x
        }
    }
}

fun main() {
    val stack = Hard895.FreqStack()
    stack.push(5)
    stack.push(7)
    stack.push(5)
    stack.push(7)
    stack.push(4)
    stack.push(5)

    println(stack.pop()) // 5
    println(stack.pop()) // 7
    println(stack.pop()) // 5
    println(stack.pop()) // 4
}