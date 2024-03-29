package medium

import BinaryTreeTopic
import HeapTopic
import MatrixTopic
import SortingTopic
import java.util.*

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */

class Medium378 : BinaryTreeTopic, SortingTopic, HeapTopic, MatrixTopic {

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val queue = PriorityQueue<Int>()
        for (i in matrix.indices) {
            for (element in matrix[i]) {
                queue.offer(element)
            }
        }
        repeat(k - 1) {
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

fun main() {
    println(Medium378().kthSmallest(arrayOf(intArrayOf(1,5,9), intArrayOf(10,11,13), intArrayOf(12,13,15)), 8))
    println(Medium378().kthSmallest(arrayOf(intArrayOf(-5)), 1))
    println(Medium378().kthSmallest(arrayOf(intArrayOf(1,2), intArrayOf(1,3)), 3))
}