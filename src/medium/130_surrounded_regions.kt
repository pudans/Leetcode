package medium

class Solution130 {

    private lateinit var board: Array<CharArray>

    fun solve(board: Array<CharArray>): Unit {
        this.board = board
        if (board.size < 3 || board[0].size < 3) {
            return
        }

        for (i in 0 until Math.max(board.size, board[0].size)) {
            if (i < board.size && board[i][0] == 'O') {
                println("find1")
                findAndDestroy(i,0)
            }
            if (i < board.size && board[i][board[0].size - 1] == 'O') {
                println("find2")
                findAndDestroy(i,board[0].size - 1)
            }
            if (i < board[0].size && board[0][i] == 'O') {
                println("find3")
                findAndDestroy(0,i)
            }
            if (i < board[0].size && board[board.size - 1][i] == 'O') {
                println("find4")
                findAndDestroy(board.size - 1,i)
            }
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                } else if (board[i][j] == '&') {
                    board[i][j] = 'O'
                }
            }
        }
    }

    private fun findAndDestroy(i: Int, j: Int) {
        println("$i $j")
        board[i][j] = '&'
        if (i in board.indices && j in board[0].indices && board[i][j] == 'O') {
            findAndDestroy(i+1,j)
            findAndDestroy(i-1,j)
            findAndDestroy(i,j+1)
            findAndDestroy(i,j-1)
        }
    }
}