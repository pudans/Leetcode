package medium

import java.util.*


class Solution207 {

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