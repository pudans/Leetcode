package medium

import java.util.*


class Solution139 {

    private val map = HashMap<String, Boolean>()

    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        if (s.isEmpty()) {
            return true
        }

        if (map.getOrDefault(s, false)) {
            return false
        }

        wordDict.forEach {
            println("try $s $it")
            if (s.indexOf(it) == 0) {
                println("find $s $it ${s.substring(it.length)}")
                if (wordBreak(s.substring(it.length), wordDict)) {
                    println("result $s $it ${s.substring(it.length)}")
                    return true
                }
            }
        }
        map[s] = true

        return false
    }








    lateinit var wordDict: List<String>
    lateinit var s: String

    fun wordBreak2(s: String, wordDict: List<String>): Boolean {
        this.wordDict = wordDict
        this.s = s

        for (j in wordDict.indices) {
            if (s[0] == wordDict[j][0]) {
                if (find(0, wordDict[j])) {
                    return true
                }
            }
        }
        return false
    }

    fun find(index: Int, word: String): Boolean {

        for (i in index until word.length) {
            if (s[i] != word[i - index]) {
                return false
            }
        }

        val newIndex = index + word.length
        if (newIndex == s.length) {
            return true
        }

        for (j in wordDict.indices) {
            if (newIndex + wordDict[j].length <= s.length && s[newIndex] == wordDict[j][0]) {
                if (find(newIndex, wordDict[j])) {
                    return true
                }
            }
        }
        return false
    }
}