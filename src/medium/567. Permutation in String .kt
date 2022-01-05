package medium

import BacktrackingTopic
import HashTableTopic
import SlidingWindowTopic
import StringTopic
import TwoPointersTopic

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 *
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
 */

class Medium567 : StringTopic, HashTableTopic, SlidingWindowTopic, TwoPointersTopic {

    fun checkInclusion(s1: String, s2: String): Boolean {
        val map = HashMap<Char, Int>()
        s1.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        println(map)
        for (i in 0..(s2.length - s1.length)) {
            if (find(s1, s2, HashMap(map), i)) return true
        }
        return false
    }

    fun find(s1: String, s2: String, map: HashMap<Char,Int>, i: Int): Boolean {
        val substr = s2.substring(i, i + s1.length)
        substr.forEach {
            val d = map[it] ?: return false
            if (d == 1) map.remove(it)
            else map[it] = d - 1
        }
        return map.isEmpty()
    }
}

fun main() {
    println(Medium567().checkInclusion("ab", "eidbaooo"))
    println(Medium567().checkInclusion("ab", "eidboaoo"))
    println(Medium567().checkInclusion("adc", "dcda"))
}