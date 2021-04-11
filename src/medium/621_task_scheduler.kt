package medium

class Solution621 {

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

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution621().leastInterval(charArrayOf('A','A','A','B','B','B'), 2)
            println(dd)
        }
    }
}