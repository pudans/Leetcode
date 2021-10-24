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

class Medium49: HashTableTopic, StringTopic, SortingTopic {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = ArrayList<List<String>>()

        if (strs.isEmpty()) {
            return result
        }
        if (strs.size == 1) {
            result.add(listOf(strs[0]))
            return result
        }

        for (i in strs.indices) {
            val str = strs[i]
            if (str != "й") {
                val resList = ArrayList<String>()
                resList.add(str)

                for (j in (i + 1) until strs.size) {
                    if (isAnagram(str, strs[j])) {
                        resList.add(strs[j])
                        strs[j] = "й"
                    }
                }
                result.add(resList)
            }
        }

        return result
    }

    private fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        var sum1: Double = 0.0
        var sum2: Double = 0.0
        for (i in s.indices) {
            sum1 += Math.sin (s[i].code.toDouble())
            sum2 += Math.sin (t[i].code.toDouble())
        }
        return Math.abs(sum1 - sum2) < 0.0000000001
    }
}

fun main() {
    println(Medium49().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
    println(Medium49().groupAnagrams(arrayOf("")))
    println(Medium49().groupAnagrams(arrayOf("a")))
}