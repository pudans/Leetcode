package medium

import java.util.*

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */

class Medium207 {

    /**
     * Bullshit
     */

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preList = ArrayList<ArrayList<Int>>(numCourses)
        val indegree = IntArray(numCourses)
        for (i in 0 until numCourses) {
            preList.add(ArrayList())
        }
        for (i in prerequisites.indices) {
            preList[prerequisites[i][0]].add(prerequisites[i][1])
            indegree[prerequisites[i][1]]++
        }
        val queue: Queue<Int> = LinkedList()
        for (i in indegree.indices) {
            if (indegree[i] == 0) {
                queue.offer(i)
            }
        }
        var count = 0
        while (!queue.isEmpty()) {
            count++
            val num = queue.poll()
            for (curr in preList[num]) {
                indegree[curr]--
                if (indegree[curr] == 0) {
                    queue.offer(curr)
                }
            }
        }
        return count == numCourses
    }
}