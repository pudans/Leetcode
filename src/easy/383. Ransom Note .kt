package easy

import medium.Easy38

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/
 *
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 */

class Easy383 {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.isEmpty()) return true
        if (magazine.length < ransomNote.length) return false
        val map = HashMap<Char, Int>()
        magazine.forEachIndexed { index, value ->
            map[value] = map.getOrDefault(value, 0) + 1
            if (index < ransomNote.length) {
                map[ransomNote[index]] = map.getOrDefault(ransomNote[index], 0) - 1
            }
        }
        if (map.values.any { it < 0 }) {
            return false
        }
        return true
    }
}

fun main() {
    println(Easy383().canConstruct("a", "b"))
    println(Easy383().canConstruct("aa", "ab"))
    println(Easy383().canConstruct("aa", "aab"))
}