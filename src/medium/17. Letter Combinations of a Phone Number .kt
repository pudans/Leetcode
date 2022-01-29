package medium

import BacktrackingTopic
import HashTableTopic
import StringTopic

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

class Medium17 : HashTableTopic, StringTopic, BacktrackingTopic {

    fun letterCombinations(digits: String): List<String> {
        val map = mapOf(
            2 to "abc",
            3 to "def",
            4 to "ghi",
            5 to "jkl",
            6 to "mno",
            7 to "pqrs",
            8 to "tuv",
            9 to "wxyz"
        )
        val result = ArrayList<String>()
        if (digits.isEmpty()) return result
        val number = digits.fold(1) { acc, c -> acc * (map[c.toString().toInt()]?.length ?: 0) }
        var gg = number
        val mn = IntArray(digits.length) {
            gg /= map[digits[it].toString().toInt()]?.length ?: 0
            return@IntArray gg
        }
        for (i in 0 until number) {
            var res1 = ""
            digits.forEachIndexed { index, char ->
                map.getOrDefault(char.toString().toInt(), "").takeIf { it.isNotEmpty() }?.let {
                    val tt = i / mn[index]
                    res1 += it[tt % it.length]
                }
            }
            result.add(res1)
        }
        return result
    }
}

fun main() {
    println(Medium17().letterCombinations("23"))
    println(Medium17().letterCombinations(""))
    println(Medium17().letterCombinations("2"))
}