package easy

class Solution463 {

    fun islandPerimeter(grid: Array<IntArray>): Int {

        var result = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {

                if (grid[i][j] == 1) {

                    if (i == grid.size - 1 || grid[i + 1][j] == 0) {
                        result++
                    }
                    if (i == 0 || grid[i - 1][j] == 0) {
                        result++
                    }
                    if (j == grid[i].size - 1 || grid[i][j + 1] == 0) {
                        result++
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        result++
                    }
                }
            }
        }
        return result
    }
}