package medium

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap


/**
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 */

class Medium451 {

    fun frequencySort(s: String): String {
        val map = HashMap<Char, Int>(s.length)
        s.forEach { char -> map[char] = map.getOrDefault(char, 0) + 1 }
        val sortedEntries = map.entries.sortedBy { -it.value }
        val result = StringBuilder()
        sortedEntries.forEach { entry -> repeat(entry.value) { result.append(entry.key) } }
        return result.toString()
    }
}

fun main() {
    println(Medium451().frequencySort("tree"))
    println(Medium451().frequencySort("cccaaa"))
    println(Medium451().frequencySort("Aabb"))
    println(Medium451().frequencySort("abaccadeeefaafcc"))
}