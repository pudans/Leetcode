package medium

import java.util.*

class Solution406 {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(kotlin.Comparator { one, two -> if (one[0] == two[0]) one[1] - two[1] else two[0] - one[0]  })
        val result = ArrayList<IntArray>()
        for (p in people) {
            result.add(p[1], p)
        }
        return Array(result.size) { result[it] }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution406().reconstructQueue(
                    arrayOf(
                            intArrayOf(7, 0),
                            intArrayOf(4, 4),
                            intArrayOf(7, 1),
                            intArrayOf(5, 0),
                            intArrayOf(6, 1),
                            intArrayOf(5, 2),
                    )
            )
            val ee = dd.joinToString { it.toList().toString() }
            println(ee)
        }
    }
}