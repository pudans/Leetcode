package medium

import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 *
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */

class Medium437 : TreeTopic, BinaryTreeTopic, DFSTopic {

    private var result: Int = 0
    private var targetSum: Long = 0

//    fun pathSum(root: easy.TreeNode?, sum: Int): Int {
//        targetSum = sum.toLong()
//
//        root?.let {
//            if (it.`val`.toLong() == targetSum) {
//                result++
//            }
//            go(it, it.`val`.toLong())
//        }
//
//        return result
//    }

    fun go(root: TreeNode?, currentSum: Long) {
        println("${root?.left?.`val`} ${root?.right?.`val`} $currentSum")

        root?.left?.let {
            val leftSum = it.`val` + currentSum
            if (leftSum == targetSum) {
                result++
                go(it, it.`val`.toLong())
            } else {
                if (it.`val`.toLong() == targetSum) {
                    result++
                }
                go(it, it.`val`.toLong())
                go(it, leftSum)
            }
        }
        root?.right?.let {
            val leftSum = it.`val` + currentSum
            if (leftSum == targetSum) {
                result++
                go(it, it.`val`.toLong())
            } else {
                if (it.`val`.toLong() == targetSum) {
                    result++
                }
                go(it, it.`val`.toLong())
                go(it, leftSum)
            }
        }
    }

    var c = 0
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return c
        val hm: HashMap<Int, Int> = HashMap()
        hm[0] = 1
        traverse(root, sum, hm, 0)
        return c
    }

    fun traverse(root: TreeNode?, sum: Int, hm: HashMap<Int, Int>, s: Int) {
        var s = s
        if (root == null) return
        s += root.`val`
        if (hm.containsKey(s - sum)) {
            c += hm[s - sum]!!
        }
        hm[s] = hm.getOrDefault(s, 0) + 1
        traverse(root.left, sum, hm, s)
        traverse(root.right, sum, hm, s)
        hm[s] = hm[s]!! - 1
    }
}