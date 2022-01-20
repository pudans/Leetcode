package easy

import StackTopic
import StringTopic
import TwoPointersTopic
import java.util.*

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 */

class Easy844 : TwoPointersTopic, StackTopic, StringTopic {

    fun backspaceCompare(S: String, T: String): Boolean = build(S) == build(T)

    private fun build(str: String): String {
        val stack = Stack<Char>()
        str.forEach { ch ->
            if (ch == '#') {
                if (stack.size > 0) stack.pop()
            } else {
                stack.push(ch)
            }
        }
        return stack.joinToString("")
    }

    fun backspaceCompare1(S: String, T: String): Boolean {

        var i = 0
        var j = 0

        var strA = S
        var strB = T

        while (i < strA.length || j < strB.length) {

            if (i < strA.length) {
                if (strA[i] == '#') {
                    if (i != 0) {
                        strA = strA.replaceRange(IntRange(i - 1, i), "")
                        i--
                    } else {
                        strA = strA.replaceRange(IntRange(i, i), "")
                    }
                } else {
                    i++
                }
            }

            if (j < strB.length) {
                if (strB[j] == '#') {
                    if (j != 0) {
                        strB = strB.replaceRange(IntRange(j - 1, j), "")
                        j--
                    } else {
                        strB = strB.replaceRange(IntRange(j, j), "")
                    }
                } else {
                    j++
                }
            }
        }
        return strA == strB
    }
}

fun main() {
    println(Easy844().backspaceCompare("ab#c", "ad#c"))
    println(Easy844().backspaceCompare("ab##", "c#d#"))
    println(Easy844().backspaceCompare("a##c", "#a#c"))
    println(Easy844().backspaceCompare("a#c", "b"))
}