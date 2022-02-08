package medium

import ArraysTopic
import TwoPointersTopic
import java.util.*


/**
 * 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 */

class Medium1091 : ArraysTopic, TwoPointersTopic {

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1
        val seen = Array(grid.size) {
            BooleanArray(
                grid[0].size
            )
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    seen[i][j] = true
                }
                grid[i][j] = Int.MAX_VALUE
            }
        }
        val q: Queue<IntArray> = LinkedList()
        grid[0][0] = 1
        seen[0][0] = true
        q.offer(intArrayOf(0, 0))
        val neighbours = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(1, 1),
            intArrayOf(-1, -1),
            intArrayOf(1, -1),
            intArrayOf(-1, 1)
        )
        while (!q.isEmpty()) {
            val cur = q.poll()
            for (neighbour in neighbours) {
                val i = cur[0] + neighbour[0]
                val j = cur[1] + neighbour[1]
                if (i >= 0 && i < grid.size && j >= 0 && j < grid[0].size && !seen[i][j]) {
                    grid[i][j] = Math.min(grid[cur[0]][cur[1]] + 1, grid[i][j])
                    seen[i][j] = true
                    q.offer(intArrayOf(i, j))
                }
            }
        }
        val res = grid[grid.size - 1][grid[0].size - 1]
        return if (res == 0 || res == Int.MAX_VALUE) -1 else res
    }

    // mine

    data class Point(val x: Int, val y: Int)

    private val memory = HashMap<Point, Int>()

    fun shortestPathBinaryMatrix1(grid: Array<IntArray>): Int {
        if (grid.first().first() == 1) return -1
        if (grid.last().last() == 1) return -1

        val result = traverse(grid, Point(0, 0), 0, HashSet())
        if (result == Int.MAX_VALUE) return -1
        return result
    }

    private fun traverse(grid: Array<IntArray>, point: Point, len: Int, visited: HashSet<Point>): Int {
        println("$point")
        if (point.x !in grid.indices) return Int.MAX_VALUE
        println("1 $point")
        if (point.y !in grid.first().indices) return Int.MAX_VALUE
        println("2 $point")
        if (grid[point.x][point.y] == 1) return Int.MAX_VALUE
        println("3 $point")
        if (visited.contains(point)) return Int.MAX_VALUE
        println("4 $point")
//        if (memory.contains(point)) return memory[point]!!
        val newLen = len + 1
        if (point.x == grid.lastIndex && point.y == grid.first().lastIndex) {
            println("1111 $point")
            return newLen
        }
        visited.add(point)

        var result = Int.MAX_VALUE
        result = minOf(result, traverse(grid, Point(point.x + 1, point.y), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x + 1, point.y + 1), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x + 1, point.y - 1), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x, point.y + 1), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x, point.y - 1), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x - 1, point.y), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x - 1, point.y + 1), newLen, HashSet(visited)))
        result = minOf(result, traverse(grid, Point(point.x - 1, point.y - 1), newLen, HashSet(visited)))

        memory[point] = result
        println("$point $result")
        return result
    }
}

fun main() {
    println(Medium1091().shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
    println(
        Medium1091().shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
    println(
        Medium1091().shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
    println(
        Medium1091().shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}