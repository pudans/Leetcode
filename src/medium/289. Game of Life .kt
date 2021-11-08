package medium

import ArraysTopic
import MatrixTopic

/**
 * 289. Game of Life
 * https://leetcode.com/problems/game-of-life/
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 */

class Medium289 : ArraysTopic, MatrixTopic {

    fun gameOfLife(board: Array<IntArray>): Unit {
        val cloned = arrayOfNulls<IntArray>(board.size)
        board.forEachIndexed { i, line ->
            cloned[i] = line.copyOf()
            line.forEachIndexed { j, value ->
                var liveCells = 0
                if (i > 0 && j > 0 && cloned[i - 1]!![j - 1] == 1) liveCells++
                if (i > 0 && cloned[i - 1]!![j] == 1) liveCells++
                if (i > 0 && j < line.size - 1 && cloned[i - 1]!![j + 1] == 1) liveCells++
                if (j < line.size - 1 && cloned[i]!![j + 1] == 1) liveCells++

                if (i < board.size - 1 && j > 0 && board[i + 1][j - 1] == 1) liveCells++
                if (i < board.size - 1 && board[i + 1][j] == 1) liveCells++
                if (i < board.size - 1 && j < line.size - 1 && board[i + 1][j + 1] == 1) liveCells++
                if (j > 0 && cloned[i]!![j - 1] == 1) liveCells++

                if (value == 1 && liveCells < 2) board[i][j] = 0
                if (value == 1 && liveCells > 3) board[i][j] = 0
                if (value == 0 && liveCells == 3) board[i][j] = 1
            }
        }
    }
}