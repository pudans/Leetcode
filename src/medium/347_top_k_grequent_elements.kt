package medium

import java.util.*
import kotlin.collections.HashMap

class Solution347 {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = HashMap<Int, Int>()

        nums.forEach {
            val value = map.getOrDefault(it, 0) + 1
            map.put(it, value)
        }

        val heap = PriorityQueue<Int>() { o1: Int, o2: Int -> (map[o1]?:0) - (map[o2]?:0) }

        map.keys.forEach { n ->
            heap.add(n)
            if (heap.size > k) heap.poll()
        }

        val result = IntArray(k) {
            heap.poll()
        }
        return result
    }
}