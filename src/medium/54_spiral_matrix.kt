package medium

class Solution54 {

    enum class Direction {
        RIGHT, DOWN, LEFT, UP
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.size == 0 || matrix[0].size == 0) {
            return listOf()
        }
        val result = ArrayList<Int>()
        val visited = HashSet<Pair<Int,Int>>()
        var i = 0
        var j = 0
        var direction = Direction.RIGHT
        val destSize = matrix.size * matrix[0].size
        while (result.size < destSize) {
            if (!visited.contains(Pair(i,j))) {
                result.add(matrix[i][j])
                visited.add(Pair(i,j))
            }
            var newi = i
            var newj = j
            when (direction) {
                Direction.RIGHT -> newj++
                Direction.DOWN -> newi++
                Direction.LEFT -> newj--
                Direction.UP -> newi--
            }

            val isNeedChangeDirect = when {
                newi >= matrix.size -> true
                newi < 0 -> true
                newj >= matrix[0].size -> true
                newj < 0 -> true
                visited.contains(Pair(newi,newj)) -> true
                else -> false
            }

            if (isNeedChangeDirect) {
                direction = changeDirection(direction)
            } else {
                i = newi
                j = newj
            }
        }
        return result
    }

    fun changeDirection(direction: Direction): Direction =
            when (direction) {
                Direction.RIGHT -> Direction.DOWN
                Direction.DOWN -> Direction.LEFT
                Direction.LEFT -> Direction.UP
                Direction.UP -> Direction.RIGHT
            }

    fun spiralOrder2(matrix: Array<IntArray>): List<Int> {
        val result = ArrayList<Int>()
        var i = 0
        var j = 0
        var direction = Direction.RIGHT
        var lastChangeDirection = false

        while (true) {
            result.add(matrix[i][j])

            matrix[i][j] = 0
            var newi = i
            var newj = j
            when (direction) {
                Direction.RIGHT -> newj++
                Direction.DOWN -> newi++
                Direction.LEFT -> newj--
                Direction.UP -> newi--
            }
            val changeDirect1 = when {
                newi >= matrix.size -> true
                newi < 0 -> true
                newj >= matrix[0].size -> true
                newj < 0 -> true
                matrix[newi][newj] == 0 -> true
                else -> false
            }
            if (changeDirect1) {
                if (lastChangeDirection) {
                    break
                } else {
                    lastChangeDirection = true
                    direction = changeDirection(direction)
                }
            } else {
                lastChangeDirection = false
            }

            i = newi
            j = newj

            println("$changeDirect1 $i $j")
        }

        return result
    }
}