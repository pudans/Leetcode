package medium

import ArraysTopic
import BacktrackingTopic
import MatrixTopic

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * BULLSHIT
 */

class Medium79 : ArraysTopic, BacktrackingTopic, MatrixTopic {

    lateinit var board: Array<CharArray>
    lateinit var word: String

    fun exist(board: Array<CharArray>, word: String): Boolean {
        this.board = board
        this.word = word

        val firstChar = word.first()

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == firstChar) {
                    if (word.length == 1) {
                        return true
                    } else {
                        if (find(i, j, 1, HashSet())) {
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    fun find(i: Int, j: Int, index: Int, set: HashSet<Int>): Boolean {
        set.add(i * 1000 + j)
        val isLast = index == word.length - 1
//        println("$i $j $index $isLast ${set.toString()}")

        return when {
            isLast && i != 0 && isTrue(i - 1, j, index, set) -> true
            isLast && j != 0 && isTrue(i, j - 1, index, set) -> true
            isLast && i + 1 < board.size && isTrue(i + 1, j, index, set) -> true
            isLast && j + 1 < board[0].size && isTrue(i, j + 1, index, set) -> true

            else -> {
                if (i != 0 && isTrue(i - 1, j, index, set) && find(i - 1, j, index + 1, HashSet(set))) {
                    return true
                }
                if (j != 0 && isTrue(i, j - 1, index, set) && find(i, j - 1, index + 1, HashSet(set))) {
                    return true
                }
                if (i + 1 < board.size && isTrue(i + 1, j, index, set) && find(i + 1, j, index + 1, HashSet(set))) {
                    return true
                }
                if (j + 1 < board[0].size && isTrue(i, j + 1, index, set) && find(i, j + 1, index + 1, HashSet(set))) {
                    return true
                }
                return false
            }
        }
    }

    fun isTrue(i: Int, j: Int, index: Int, set: HashSet<Int>): Boolean =
        !set.contains(i * 1000 + j) && board[i][j] == word[index]
}