package medium

import MatrixTopic

/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/
 *
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.
 */

class Medium695 : MatrixTopic {

    data class Point(val x: Int, val y: Int)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val allSet = HashSet<Point>()
        var result = 0
        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == 1) {
                    val oldSize = allSet.size
                    find(grid, allSet, Point(i,j))
                    val newSize = allSet.size - oldSize
                    if (newSize > result) {
                        result = newSize
                    }
                }
            }
        }
        return result
    }

    private fun find(
        image: Array<IntArray>,
        points: HashSet<Point>,
        point: Point,
    ) {
        if (point.x !in image.indices) return
        if (point.y !in image.first().indices) return
        if (points.contains(point)) return
        if (image[point.x][point.y] != 1) return
        points.add(point)
        find(image, points, Point(point.x, point.y + 1))
        find(image, points, Point(point.x, point.y - 1))
        find(image, points, Point(point.x + 1, point.y))
        find(image, points, Point(point.x - 1, point.y))
    }
}