package easy

import HashTableTopic
import StringTopic

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 *
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */

class Easy290 : HashTableTopic, StringTopic {

    fun wordPattern(pattern: String, s: String): Boolean {
        val split = s.split(" ")
        if (pattern.length != split.size) return false
        val map = HashMap<Char, String>()
        for (i in pattern.indices) {
            val str = map[pattern[i]]
            if (str == null) {
                if (map.containsValue(split[i])) return false
                map[pattern[i]] = split[i]
            } else {
                if (str != split[i]) return false
            }
        }
        return true
    }
}

fun main() {
    println(Easy290().wordPattern("abba", "dog cat cat dog"))
    println(Easy290().wordPattern("abba", "dog cat cat fish"))
    println(Easy290().wordPattern("aaaa", "dog cat cat dog"))
    println(Easy290().wordPattern("abba", "dog dog dog dog"))
}