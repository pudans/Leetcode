package medium

class Solution64 {

    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i == 0) {
                    if (j != 0) {
                        grid[i][j] += grid[i][j - 1]
                    }
                } else {
                    if (j != 0) {
                        grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j])
                    } else {
                        grid[i][j] += grid[i - 1][j]
                    }
                }
            }
        }
        return grid.last().last()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val data = arrayOf(
                intArrayOf(1,3,1),
                intArrayOf(1,5,1),
                intArrayOf(4,2,1)
            )
            val data1 = arrayOf(
                intArrayOf(1,2,3),
                intArrayOf(4,5,6)
            )
            println(Solution64().minPathSum(data1))
        }
    }

}