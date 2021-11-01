package medium

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

class Medium130 {

    fun solve(board: Array<CharArray>): Unit {
        if (board.size < 3 || board[0].size < 3) return
        for (i in 0 until Math.max(board.size, board[0].size)) {
            if (isO(i, 0, board)) findBorders(i, 0, board)
            if (isO(i, board[0].size - 1, board)) findBorders(i, board[0].size - 1, board)
            if (isO(0, i, board)) findBorders(0, i, board)
            if (isO(board.size - 1, i, board)) findBorders(board.size - 1, i, board)
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                when {
                    board[i][j] == 'O' -> board[i][j] = 'X'
                    board[i][j] == '&' -> board[i][j] = 'O'
                }
            }
        }
    }

    private fun isO(i: Int, j: Int, board: Array<CharArray>) = board.getOrNull(i)?.getOrNull(j) == 'O'

    private fun findBorders(i: Int, j: Int, board: Array<CharArray>) {
        if (isO(i, j, board)) {
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