package medium

import HashTableTopic
import SlidingWindowTopic

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
 */

class Medium395 : HashTableTopic, SlidingWindowTopic {

    /**
     * Bullshit
     */

    fun longestSubstring(s: String, k: Int): Int {
        return div(s, 0, s.length, k)
    }

    fun div(s: String, start: Int, end: Int, k: Int): Int {
        if (end - start < k) {
            return 0
        }
        val hist = IntArray(26)
        for (i in start until end) {
            hist[s[i] - 'a']++
        }
        var max = 0
        var i = start

        for (j in start until end) {
            if (hist[s[j] - 'a'] < k) {
                max = Math.max(max, div(s, i, j, k))
                i = j + 1
            } else if (j == end - 1) {
                if (i == start) {
                    return end - start
                }
                max = Math.max(max, div(s, i, j + 1, k))
            }
        }
        return max
    }
}