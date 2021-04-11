package medium

class Solution289 {
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

//                println("$i $j ${cloned[i][j]} $liveCells")

                if (value == 1 && liveCells < 2) board[i][j] = 0
                if (value == 1 && liveCells > 3) board[i][j] = 0
                if (value == 0 && liveCells == 3) board[i][j] = 1

                // println("$i $j ${cloned[i]!![j]} $liveCells")
            }
        }
    }
}