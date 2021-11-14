package hard

import ArraysTopic
import BacktrackingTopic
import BitManipulationTopic
import MatrixTopic

/**
 * 980. Unique Paths III
 * https://leetcode.com/problems/unique-paths-iii/
 *
 * You are given an m x n integer array grid where grid[i][j] could be:
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 */

class Hard980 : ArraysTopic, MatrixTopic, BitManipulationTopic, BacktrackingTopic {

    data class Point(val x: Int, val y: Int)

    lateinit var start: Point
    lateinit var grid: Array<IntArray>
    var movesCount = 0

    fun uniquePathsIII(grid: Array<IntArray>): Int {
        this.grid = grid

        for (i in grid.indices) {
            for (j in 0 until grid.first().size) {
                when (grid[i][j]) {
                    0 -> movesCount++
                    1 -> start = Point(i, j)
                }
            }
        }
        return canWalk(start, ArrayList())
    }

    private fun canWalk(point: Point, walked: ArrayList<Point>): Int {
        if (grid[point.x][point.y] == -1) return 0
        if (walked.contains(point)) return 0
        if (grid[point.x][point.y] == 2 && (movesCount+1) == walked.size) return 1
        if (grid[point.x][point.y] == 2) return 0

        walked.add(point)

        return (grid.getOrNull(point.x + 1)?.getOrNull(point.y)
            ?.let { canWalk(Point(point.x + 1, point.y), ArrayList(walked)) } ?: 0) +
                (grid.getOrNull(point.x - 1)?.getOrNull(point.y)
                    ?.let { canWalk(Point(point.x - 1, point.y), ArrayList(walked)) } ?: 0) +
                (grid.getOrNull(point.x)?.getOrNull(point.y + 1)
                    ?.let { canWalk(Point(point.x, point.y + 1), ArrayList(walked)) } ?: 0) +
                (grid.getOrNull(point.x)?.getOrNull(point.y - 1)
                    ?.let { canWalk(Point(point.x, point.y - 1), ArrayList(walked)) } ?: 0)
    }
}

fun main() {
    println(Hard980().uniquePathsIII(
        arrayOf(
            intArrayOf(1,0,0,0),
            intArrayOf(0,0,0,0),
            intArrayOf(0,0,2,-1),
        )
    ))
    println(Hard980().uniquePathsIII(
        arrayOf(
            intArrayOf(1,0,0,0),
            intArrayOf(0,0,0,0),
            intArrayOf(0,0,0,2),
        )
    ))
    println(Hard980().uniquePathsIII(
        arrayOf(
            intArrayOf(0,1),
            intArrayOf(2,0)
        )
    ))
}