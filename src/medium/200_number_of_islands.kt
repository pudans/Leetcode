package medium

class Solution200 {

    lateinit var visited: Array<BooleanArray>
    lateinit var grid: Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        this.grid = grid
        this.visited = Array(grid.size) {
            BooleanArray(grid[0].size) { false }
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '0') {
                    continue
                }
                if (visited[i][j]) {
                    continue
                }
                findLand(i,j)
                println("-----------")
                result++
            }
        }
        return result
    }

    private fun findLand(i: Int, j: Int) {
        println("$i-$j")
        if (grid[i][j] == '0') {
            return
        }
        if (visited[i][j]) {
            return
        }
        visited[i][j] = true
        if (i < grid.size - 1) {
            findLand(i + 1, j)
        }
        if (j < grid[i].size - 1) {
            findLand(i, j + 1)
        }
        if (j > 0) {
            findLand(i, j - 1)
        }
        if (i > 0) {
            findLand(i - 1, j)
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val grid = arrayOf(
                charArrayOf('1','0','1','1','1'),
                charArrayOf('1','0','1','0','1'),
                charArrayOf('1','1','1','0','1')
            )

            println(Solution200().numIslands(grid))
        }
    }

}