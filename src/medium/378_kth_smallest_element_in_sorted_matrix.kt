package medium

import java.util.*


class Solution378 {

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val queue = PriorityQueue<Int>()
        for (i in matrix.indices) {
            for (element in matrix[i]) {
                queue.offer(element)
            }
        }
        for (i in 0..(k-2)) {
            queue.poll()
        }
        return queue.poll()
    }

    fun kthSmallest3(matrix: Array<IntArray>, k: Int): Int {
        return matrix.flatMap { it.toList() }.sorted()[k - 1]
    }

    fun kthSmallest2(matrix: Array<IntArray>, k: Int): Int {
        val set = TreeSet<Int>()
        matrix.forEach { i ->
            i.forEach {
                set.add(it)
            }
        }
        return set.elementAt(k)
    }
}