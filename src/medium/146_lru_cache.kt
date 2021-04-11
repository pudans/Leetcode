package medium

import java.util.*
import kotlin.collections.HashMap

class LRUCache(private val capacity: Int) {

    private val map = HashMap<Int,Int>()
    private val queue = LinkedList<Int>()

    fun get(key: Int): Int {
        val result = map.getOrDefault(key, - 1)
        if (result >= 0) {
            queue.remove(key)
            queue.addLast(key)
        }
        return result
    }

    fun put(key: Int, value: Int) {
        map[key] = value

        if (!queue.contains(key)) {
            queue.addLast(key)
            if (queue.size > capacity) {
                val removed = queue.pollFirst()
                map.remove(removed)
            }
        } else {
            queue.remove(key)
            queue.addLast(key)
        }
    }

}