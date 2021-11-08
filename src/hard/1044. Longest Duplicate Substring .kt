package hard

import BinarySearchTopic
import HashTableTopic
import SlidingWindowTopic


/**
 * 1044. Longest Duplicate Substring
 * https://leetcode.com/problems/longest-duplicate-substring/
 *
 * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.
 * Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".
 *
 * BULLSHIT
 */

class Hard1044: BinarySearchTopic, SlidingWindowTopic, HashTableTopic {

    fun longestDupSubstring(s: String): String {
        var low = 0
        var high = s.length
        val prime = (1 shl 31) - 1
        val letterSize = 26
        var longestDupSub = ""
        while (low <= high) {
            val mid = low + (high - low) / 2
            val dupSub = search(s, mid, prime, letterSize)
            if (dupSub == null) {
                high = mid - 1
            } else {
                if (dupSub.length > longestDupSub.length) longestDupSub = dupSub
                low = mid + 1
            }
        }
        return longestDupSub
    }

    /**
     * @param s          The original string
     * @param windowSize rolling hash window size controlled by mid
     * @param Q          a big prime
     * @param L          letter size
     * @return duplicate substring if any else null
     */
    private fun search(s: String, windowSize: Int, Q: Int, L: Int): String? {
        // calculate hash of first window
        var winHash = 0L
        for (i in 0 until windowSize) winHash = (L * winHash + s[i].toLong()) % Q
        val map = HashMap<Long, MutableList<Int>>()
        map[winHash] = ArrayList(listOf(0))
        var E = 1L // L ^ pattern length mod Q
        for (i in 1 until windowSize) E = L * E % Q
        for (i in 1..s.length - windowSize) {
            // remove first char
            winHash = (winHash - E * s[i - 1].toLong() % Q + Q) % Q
            // left shift
            winHash = winHash * L % Q
            // add new last char
            winHash = (winHash + s[i + windowSize - 1].toLong()) % Q

            // hash collision
            if (map.containsKey(winHash)) for (start in map[winHash]!!) if (isEqual(s, start, i, windowSize)) return s.substring(i, i + windowSize)
            map.computeIfAbsent(winHash) { k: Long? -> ArrayList() }.add(i)
        }
        return null
    }

    private fun isEqual(s: String, previous: Int, current: Int, windowSize: Int): Boolean {
        var previous = previous
        var current = current
        for (j in 0 until windowSize) if (s[previous++] != s[current++]) return false
        return true
    }
}

fun main() {
    println(Hard1044().longestDupSubstring("banana"))
    println(Hard1044().longestDupSubstring("abcd"))
    println(Hard1044().longestDupSubstring("ssss"))
    println(Hard1044().longestDupSubstring("sasb"))
}