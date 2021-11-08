package medium

import GreedyTopic
import HashTableTopic
import HeapTopic
import SortingTopic
import java.util.*

/**
 * 1054. Distant Barcodes
 * https://leetcode.com/problems/distant-barcodes/
 *
 * In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].
 * Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.
 */

class Medium1054 : HashTableTopic, GreedyTopic, SortingTopic, HeapTopic {

    fun rearrangeBarcodes(barcodes: IntArray): IntArray {
        val result = IntArray(barcodes.size)
        val map = HashMap<Int,Int>()
        for (b in barcodes) {
            map[b] = map.getOrDefault(b, 0) + 1
        }
        val maxHeap = PriorityQueue { a: Int, b: Int -> map[b]!! - map[a]!! }
        maxHeap.addAll(map.keys)
        var index = 0
        while (maxHeap.size > 0) {
            val valueA = maxHeap.poll()
            result[index++] = valueA
            if (maxHeap.size == 0) break
            val valueB = maxHeap.poll()
            result[index++] = valueB
            update(map, maxHeap, valueA)
            update(map, maxHeap, valueB)
        }
        return result
    }

    private fun update(map: HashMap<Int, Int>, maxHeap: PriorityQueue<Int>, value: Int) {
        if (map[value] == 1) {
            map.remove(value)
        } else {
            map[value] = map[value]!! - 1
            maxHeap.offer(value)
        }
    }
}

fun main() {
    println(Medium1054().rearrangeBarcodes(intArrayOf(1,1,1,1,2,2,3,3)).toList())
}