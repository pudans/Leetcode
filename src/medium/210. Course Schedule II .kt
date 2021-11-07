package medium

import BFSTopic
import DFSTopic

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */

class Medium210 : DFSTopic, BFSTopic{

    /**
     * Bullshit
     */

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray? {
        val adjList: Array<ArrayList<Int>> = Array(numCourses) {
            ArrayList()
        }
        for (pairOfCourse in prerequisites) {
            adjList[pairOfCourse[1]].add(pairOfCourse[0])
        }
        val visited = IntArray(numCourses)
        for (i in 0 until numCourses) {
            if (!isSafe(adjList, i, visited)) {
                return IntArray(0)
            }
        }
        val orderOfCourse = ArrayList<Int>()
        val markVisited = BooleanArray(numCourses)
        for (i in 0 until numCourses) {
            DFS(adjList, i, markVisited, orderOfCourse)
        }
        orderOfCourse.reverse()
        val answer = IntArray(numCourses)
        for (i in orderOfCourse.indices) {
            answer[i] = orderOfCourse[i]
        }
        return answer
    }

    private fun DFS(adjList: Array<ArrayList<Int>>, idx: Int, markVisited: BooleanArray, orderOfCourse: ArrayList<Int>) {
        if (!markVisited[idx]) {
            markVisited[idx] = true
            for (i in adjList[idx].indices) {
                DFS(adjList, adjList[idx][i], markVisited, orderOfCourse)
            }
            orderOfCourse.add(idx)
        }
    }

    private fun isSafe(adjList: Array<ArrayList<Int>>, idx: Int, visited: IntArray): Boolean {
        if (visited[idx] == 2) return true
        if (visited[idx] == 1) return false
        visited[idx] = 1
        val neighbours: List<Int> = adjList[idx]
        for (i in neighbours.indices) {
            if (visited[neighbours[i]] == 2) continue
            if (visited[neighbours[i]] == 1 || !isSafe(adjList, neighbours[i], visited)) {
                return false
            }
        }
        visited[idx] = 2
        return true
    }
}