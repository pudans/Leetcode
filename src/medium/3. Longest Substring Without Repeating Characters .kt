package medium

import HashTableTopic
import SlidingWindowTopic
import StringTopic

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */

class Medium3: HashTableTopic, StringTopic, SlidingWindowTopic {

    fun lengthOfLongestSubstring(s: String): Int {
        var map = HashMap<Char, Int>()
        var result = 0
        for (i in s.indices) {
            val dd = map[s[i]]
            if (dd == null) {
                map[s[i]] = i
            } else {
                result = Math.max(result, map.size)
                map = map.filterTo(HashMap()) { dd < it.value }
                map[s[i]] = i
            }
        }
        result = Math.max(result, map.size)
        return result
    }
}

fun main() {
    println(Medium3().lengthOfLongestSubstring("dvdf"))
    println(Medium3().lengthOfLongestSubstring("abcabcbb"))
    println(Medium3().lengthOfLongestSubstring("bbbbb"))
    println(Medium3().lengthOfLongestSubstring("pwwkew"))
}