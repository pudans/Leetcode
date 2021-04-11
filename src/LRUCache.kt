import java.util.*
import kotlin.collections.HashMap

class LRUCache<Key, Value>(
    private val capacity: Int = 20
) {

    private val map = HashMap<Key,Value>()
    private val queue: Queue<Key> = LinkedList()

    fun put(key: Key, value: Value) {
        if (map.containsKey(key)) {
            queue.remove(key)
        }
        map[key] = value
        queue.add(key)
        if (map.size > capacity) {
            map.remove(queue.poll())
        }
    }

    fun get(key: Key): Value? {
        val value = map[key]
        if (value != null) {
            queue.remove(key)
            queue.add(key)
        }
        return value
    }

    fun values() = map.values

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val cache = LRUCache<Int, Int>(3)
            cache.put(34, 67)
            cache.put(44, 55)
            cache.put(22, 88)
            println(cache.values())
            cache.get(34)
            cache.put(33, 99)
            println(cache.values())

        }
    }
}