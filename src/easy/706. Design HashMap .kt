package easy

import HashTableTopic

/**
 * 706. Design HashMap
 * https://leetcode.com/problems/binary-search/
 *
Design a HashMap without using any built-in hash table libraries.
Implement the MyHashMap class:
MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 */

class Easy706 : HashTableTopic {

    class MyHashMap {

        private var keyValuePair = IntArray(1000001) { -1 }

        fun put(key: Int, value: Int) {
            keyValuePair[key] = value
        }

        fun get(key: Int): Int = if (keyValuePair[key] != -1) keyValuePair[key] else -1

        fun remove(key: Int) {
            keyValuePair[key] = -1
        }
    }
}