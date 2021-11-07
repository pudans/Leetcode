package medium

import HashTableTopic
import SlidingWindowTopic

/**
 *  438. Find All Anagrams in a String
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 *  Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

class Medium438 : HashTableTopic, SlidingWindowTopic {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        if (s.length < p.length) {
            return result
        }
        var dd = 0.0
        var pp = 0.0
        for (i in 0 until p.length) {
            dd += Math.sin(p[i].toDouble())
            pp += Math.sin(s[i].toDouble())
        }
        if (Math.abs(dd - pp) < 0.0000000001) {
            result.add(0)
        }
        for (i in 1..(s.length - p.length)) {
            println("$i ${i - 1} ${i + p.length - 1}")

            pp -= Math.sin(s[i - 1].toDouble())
            pp += Math.sin(s[i + p.length - 1].toDouble())
            if (Math.abs(dd - pp) < 0.0000000001) {
                result.add(i)
            }
        }
        return result
    }
}

fun main() {
    println(Medium438().findAnagrams("cbaebabacd", "abc"))
}