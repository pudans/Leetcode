package easy

import StringTopic

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 */

class Easy58: StringTopic {

    fun lengthOfLastWord(s: String): Int {
        val targetStr = s.trim()
        if (targetStr.isEmpty()) {
            return 0
        }
        for (i in (targetStr.length - 1) downTo 0) {
            if (targetStr[i] == ' ') {
                return targetStr.length - 1 - i
            }
        }
        return targetStr.length
    }
}

fun main() {
    println(Easy58().lengthOfLastWord("Hello World"))
    println(Easy58().lengthOfLastWord("   fly me   to   the moon  "))
    println(Easy58().lengthOfLastWord("luffy is still joyboy"))
}