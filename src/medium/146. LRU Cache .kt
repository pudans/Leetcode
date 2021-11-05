package medium

import DoubleLinkedListTopic
import HashTableTopic
import LinkedListTopic
import java.util.*

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

class Medium146: HashTableTopic, LinkedListTopic, DoubleLinkedListTopic {

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
}

fun main() {
    val cache = Medium146.LRUCache(2)
    cache.put(1,1)
    cache.put(2,2)
    println(cache.get(1))
    cache.put(3,3)
    println(cache.get(2))
    cache.put(4,4)
    println(cache.get(1))
    println(cache.get(3))
    println(cache.get(4))
}