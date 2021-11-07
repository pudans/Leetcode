package medium

import GreedyTopic
import HashTableTopic
import HeapTopic

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 *
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
 * Tasks could be done in any order. Each task is done in one unit of time.
 * For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.
 */

class Medium621 : HashTableTopic, GreedyTopic, HeapTopic {

    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0) return tasks.size
        val cols = IntArray(26)
        tasks.forEach { cols[it - 'A']++ }

        var maxFreq = Int.MIN_VALUE
        var maxCount = 0

        for (i in cols.indices) {
            if (cols[i] == maxFreq) {
                maxCount++
            } else if (cols[i] > maxFreq) {
                maxFreq = cols[i]
                maxCount = 1
            }
        }

        val emptySlots = (maxFreq - 1) * (n - (maxCount - 1))
        val availableTasks = tasks.size - maxCount * maxFreq
        val idles = Math.max(0, emptySlots - availableTasks)

        return tasks.size + idles
    }
}

fun main() {
    println(Medium621().leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
}