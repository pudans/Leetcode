package medium

import HashTableTopic
import SortingTopic
import StringTopic

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */

class Medium49 : HashTableTopic, StringTopic, SortingTopic {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return emptyList()
        if (strs.size == 1) return listOf(listOf(strs.first()))
        val result = mutableListOf<ArrayList<String>>()
        fun add(str: String) {
            for (j in result.indices) {
                if (isAnagram(str, result[j].first())) {
                    result[j].add(str)
                    return
                }
            }
            result.add(arrayListOf(str))
        }
        strs.forEach { add(it) }
        return result
    }

    private fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        var sum1 = 0.0
        var sum2 = 0.0
        for (i in s.indices) {
            sum1 += Math.sin(s[i].toDouble())
            sum2 += Math.sin(t[i].toDouble())
        }
        return Math.abs(sum1 - sum2) < 0.0000000001
    }
}

fun main() {
    println(Medium49().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    println(Medium49().groupAnagrams(arrayOf("")))
    println(Medium49().groupAnagrams(arrayOf("a")))
}