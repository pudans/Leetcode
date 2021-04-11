package medium

import kotlin.random.Random

class RandomizedSet() {

    private val map = HashMap<Int,Boolean>()
    private val random = Random(System.currentTimeMillis())

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (!map.getOrDefault(`val`, false)) {
            map[`val`] = true
            return true
        } else {
            return false
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        return map.remove(`val`) != null
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        if (map.size > 0) {
            return map.keys.elementAt(random.nextInt(map.size))
        } else {
            return 0
        }
    }

}