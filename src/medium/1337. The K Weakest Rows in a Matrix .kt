package medium

import ArraysTopic
import BinarySearchTopic
import HeapTopic
import MatrixTopic
import SortingTopic

/**
 * 1337. The K Weakest Rows in a Matrix
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
A row i is weaker than a row j if one of the following is true:
The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */

class Medium1337 : BinarySearchTopic, ArraysTopic, SortingTopic, HeapTopic, MatrixTopic {

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val soldies = IntArray(mat.size) { mat[it].sumBy { it } }
        return IntArray(k) {
            var min = Int.MAX_VALUE
            var index = 0
            for (j in soldies.indices) {
                if (soldies[j] < min) {
                    min = soldies[j]
                    index = j
                }
            }
            soldies[index] = Int.MAX_VALUE
            index
        }
    }
}