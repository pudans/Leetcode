package medium

import DynamicProgrammingTopic
import HashTableTopic
import StringTopic
import TrieTopic

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */

class Medium139 : HashTableTopic, StringTopic, DynamicProgrammingTopic, TrieTopic {

    private val map = HashMap<String, Boolean>()

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return true
        if (map.getOrDefault(s, false)) return false
        wordDict.forEach {
            if (s.indexOf(it) == 0 && wordBreak(s.substring(it.length), wordDict)) {
                return true
            }
        }
        map[s] = true
        return false
    }
}

fun main() {
    println(Medium139().wordBreak("leetcode", listOf("leet", "code")))
    println(Medium139().wordBreak("applepenapple", listOf("apple", "pen")))
    println(Medium139().wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))

}