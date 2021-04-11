package medium

class Solution79 {

    lateinit var board: Array<CharArray>
    lateinit var word: String

    fun exist(board: Array<CharArray>, word: String): Boolean {
        this.board = board
        this.word = word

        val firstChar = word[0]

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == firstChar) {
                    if (word.length == 1) {
                        return true
                    } else {
                        val finded = find(i, j, 1, HashSet())
                        if (finded) {
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
            isLast && i != 0 && isTrue(i-1,j,index, set) -> true
            isLast && j != 0 && isTrue(i,j-1,index, set) -> true
            isLast && i+1 < board.size && isTrue(i+1,j,index, set) -> true
            isLast && j+1 < board[0].size && isTrue(i,j+1,index, set) -> true

            else -> {
                if (i != 0 && isTrue(i-1,j,index, set) && find(i-1,j,index+1, HashSet(set))) {
                    return true
                }
                if (j != 0 && isTrue(i,j-1,index, set) && find(i,j-1,index+1, HashSet(set))) {
                    return true
                }
                if (i+1 < board.size && isTrue(i+1,j,index, set) && find(i+1,j,index+1, HashSet(set))) {
                    return true
                }
                if (j+1 < board[0].size && isTrue(i,j+1,index, set) && find(i,j+1,index+1, HashSet(set))) {
                    return true
                }
                return false
            }
        }
    }

    fun isTrue(i: Int, j: Int, index: Int, set: HashSet<Int>): Boolean {
        return !set.contains(i * 1000 + j)
                && board[i][j] == word[index]
    }
}