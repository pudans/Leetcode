package medium

class Solution36 {

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