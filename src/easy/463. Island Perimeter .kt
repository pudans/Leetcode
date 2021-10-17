package easy

/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */

class Easy463 {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
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