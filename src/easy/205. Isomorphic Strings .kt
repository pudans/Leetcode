package easy

import java.util.*

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */

class Easy205 {

    fun isIsomorphic(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        val map = HashMap<Char, Char>()
        for (i in s1.indices) {
            when {
                !map.containsKey(s1[i]) && map.containsValue(s2[i]) -> return false
                !map.containsKey(s1[i]) -> map[s1[i]] = s2[i]
                map[s1[i]] != s2[i] -> return false
            }
        }
        return true
    }
}

fun main() {
    println(Easy205().isIsomorphic("egg", "add"))
    println(Easy205().isIsomorphic("foo", "bar"))
    println(Easy205().isIsomorphic("paper", "title"))
}