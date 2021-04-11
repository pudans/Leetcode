package medium

import java.util.PriorityQueue
import java.util.HashMap

class Solution1054 {

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

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution1054().rearrangeBarcodes(intArrayOf(1,1,1,1,2,2,3,3)).toList())
        }
    }
}