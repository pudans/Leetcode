package medium

import java.lang.StringBuilder
import java.util.*

class Solution739 {

    fun dailyTemperatures(array: IntArray): IntArray {
        val result = IntArray(array.size)
        val stack = PriorityQueue<Pair<Int,Int>> { o1, o2 -> o1.second - o2.second }
        stack.offer(Pair(0, array[0]))
        for (i in 1 until array.size) {
            while (stack.peek() != null && stack.peek().second < array[i]) {
                val dd = stack.poll()
                result[dd.first] = i - dd.first
            }
            stack.offer(Pair(i, array[i]))
            println(stack.string())
        }
        return result
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val data = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
            println(Solution739().dailyTemperatures(data).toList())
        }

        fun PriorityQueue<*>.string(): String {
            val str = StringBuilder()
            val dd = PriorityQueue(this)
            while (dd.peek() != null) {
                str.append(dd.poll()).append(", ")
            }
            return str.toString()
        }
    }


}