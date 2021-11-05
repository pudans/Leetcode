package medium

import BinarySearchTopic
import BinaryTreeTopic
import DynamicProgrammingTopic
import MathTopic
import TreeTopic

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */

class Medium96: MathTopic, DynamicProgrammingTopic, TreeTopic, BinaryTreeTopic, BinarySearchTopic {

    fun numTrees(n: Int): Int {
        val arr = IntArray(n + 1)
        arr[0] = 1
        arr[1] = 1
        for (i in 2..n) {
            for (j in 0 until i) {
                arr[i] += arr[j] * arr[i - j - 1]
            }
        }
        return arr.last()
    }
}

fun main() {
    println(Medium96().numTrees(3))
    println(Medium96().numTrees(1))
}