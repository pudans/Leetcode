package medium

import HashTableTopic
import HeapTopic
import SortingTopic
import java.util.*

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */

class Medium347 : HashTableTopic, SortingTopic, HeapTopic {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = HashMap<Int, Int>()

        nums.forEach {
            val value = map.getOrDefault(it, 0) + 1
            map.put(it, value)
        }

        val heap = PriorityQueue<Int>() { o1: Int, o2: Int -> (map[o1] ?: 0) - (map[o2] ?: 0) }

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