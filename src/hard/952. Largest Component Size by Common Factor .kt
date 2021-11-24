package hard

import ArraysTopic
import MathTopic
import UnionFindTopic
import java.util.*


/**
 * 952. Largest Component Size by Common Factor
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 *
You are given an integer array of unique positive integers nums. Consider the following graph:
There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.
 */

class Hard952 : ArraysTopic, MathTopic, UnionFindTopic {

    private fun find(x: Int, parent: IntArray): Int =
            when (parent[x] == -1) {
                true -> x
                false -> {
                    parent[x] = find(parent[x], parent)
                    parent[x]
                }
            }

    private fun union(x: Int, y: Int, parent: IntArray) {
        val xp = find(x, parent)
        val yp = find(y, parent)
        if (xp != yp) {
            parent[yp] = xp
        }
    }

    fun largestComponentSize(nums: IntArray): Int {
        val parent = IntArray(100001) { -1 }
        var i = 0
        while (i < nums.size) {
            var k = 2
            while (k <= Math.sqrt(nums[i].toDouble())) {
                if (nums[i] % k == 0) {
                    union(nums[i], k, parent)
                    union(nums[i], nums[i] / k, parent)
                }
                k++
            }
            i++
        }
        var count = 0
        val map = HashMap<Int, Int>()
        i = 0
        while (i < nums.size) {
            val p = find(nums[i], parent)
            count = Math.max(count, map.getOrDefault(p, 0) + 1)
            map[p] = map.getOrDefault(p, 0) + 1
            i++
        }
        return count
    }
}

fun main() {
    println(Hard952().largestComponentSize(intArrayOf(4, 6, 15, 35)))
    println(Hard952().largestComponentSize(intArrayOf(20, 50, 9, 63)))
    println(Hard952().largestComponentSize(intArrayOf(2, 3, 6, 7, 4, 12, 21, 39)))
}