package easy

import ArraysTopic
import GreedyTopic
import MathTopic
import StringTopic
import TwoPointersTopic

/**
 * 942. DI String Match
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 */

class Easy942 : ArraysTopic, TwoPointersTopic, StringTopic, GreedyTopic, MathTopic {

    fun diStringMatch(s: String): IntArray {
        val result = IntArray(s.length + 1)
        var top = 0
        var bottom = 0
        for (i in result.lastIndex - 1 downTo 0) {
            if (s[i] == 'I') {
                bottom--
                result[i] = bottom
            } else {
                top++
                result[i] = top
            }
        }
        return result.also { for (i in it.indices) it[i] -= bottom }
    }
}

fun main() {
    println(Easy942().diStringMatch("IDID").toList())
    println(Easy942().diStringMatch("III").toList())
    println(Easy942().diStringMatch("DDI").toList())
}