package medium

import ArraysTopic
import HashTableTopic
import MatrixTopic

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

class Medium36: ArraysTopic, HashTableTopic, MatrixTopic {

    val map = HashMap<Int, HashSet<Char>>()

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            for (j in 0..8) {
                val ch = board[i][j]
                if (check(i,ch)) {
                    println("1 $i $j $ch")
                    return false
                }
                if (check(j+10,ch)) {
                    println("2 $i $j $ch")
                    return false
                }
                val x = (i / 3) * 10
                val y = (j / 3) * 100
                if (check((x+y)+20,ch)) {
                    println("3 $i $j $x $y $ch")
                    return false
                }
            }
        }
        return true
    }

    fun check(key: Int, ch: Char): Boolean {
        if (ch == '.') return false
        var hash = map[key]
        if (hash == null) {
            hash = HashSet()
            hash!!.add(ch)
            map[key] = hash
            return false
        } else {
            val contains = hash.contains(ch)
            hash.add(ch)
            map[key] = hash
            return contains
        }
    }
}