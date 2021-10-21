package medium

import kotlin.random.Random

/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * Implement the RandomizedSet class:
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

class Medium380 {

    class RandomizedSet {

        private val set = HashSet<Int>()
        private val random = Random(System.nanoTime())

        fun insert(`val`: Int): Boolean = set.add(`val`)

        fun remove(`val`: Int): Boolean = set.remove(`val`)

        fun getRandom(): Int = set.random(random)
    }
}

fun main() {
    val set = Medium380.RandomizedSet()
    println(set.insert(10))
    println(set.insert(11))
    println(set.insert(12))
    println(set.insert(13))
    println(set.remove(13))
    println(set.getRandom())
    println(set.getRandom())
    println(set.getRandom())
    println(set.getRandom())
}
