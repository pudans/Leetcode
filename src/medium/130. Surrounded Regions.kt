package medium

import ArraysTopic
import BFSTopic
import DFSTopic
import MatrixTopic

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

class Medium130 : ArraysTopic, MatrixTopic, BFSTopic, DFSTopic {

    fun solve(board: Array<CharArray>) {
        if (board.size < 3 || board[0].size < 3) return
        for (i in 0 until maxOf(board.size, board.first().size)) {
            findBorders(i, 0, board)
            findBorders(i, board.first().lastIndex, board)
            findBorders(0, i, board)
            findBorders(board.lastIndex, i, board)
        }
        for (i in board.indices) {
            for (j in board.first().indices) {
                board[i][j] = when (board[i][j]) {
                    'O' -> 'X'
                    '&' -> 'O'
                    else -> board[i][j]
                }
            }
        }
    }

    private fun findBorders(i: Int, j: Int, board: Array<CharArray>) {
        if (board.getOrNull(i)?.getOrNull(j) == 'O') {
            board[i][j] = '&'
            findBorders(i + 1, j, board)
            findBorders(i - 1, j, board)
            findBorders(i, j + 1, board)
            findBorders(i, j - 1, board)
        }
    }
}

fun main() {
    val input = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X'),
    )
    Medium130().solve(input)
    println(input.toList().map { it.toList() })
}