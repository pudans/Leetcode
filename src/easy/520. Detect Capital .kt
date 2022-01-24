package easy

import StringTopic

/**
 * 520. Detect Capital
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */

class Easy520 : StringTopic {

    fun detectCapitalUse(word: String): Boolean {
        if (word.length == 1) return true
        val firstIsCapital = word.first().isUpperCase()
        val secondIsCapital = word[1].isUpperCase()
        if (!firstIsCapital && secondIsCapital) return false
        for (i in 2 until word.length) {
            if (word[i].isUpperCase() != secondIsCapital) return false
        }
        return true
    }
}

fun main() {
//    println(Easy520().detectCapitalUse("a"))
//    println(Easy520().detectCapitalUse("A"))

    println(Easy520().detectCapitalUse("aa"))
    println(Easy520().detectCapitalUse("Aa"))
    println(Easy520().detectCapitalUse("AA"))
    println(Easy520().detectCapitalUse("aA"))

//    println(Easy520().detectCapitalUse("asd"))
//    println(Easy520().detectCapitalUse("aSd"))
//    println(Easy520().detectCapitalUse("Asd"))
//    println(Easy520().detectCapitalUse("ASd"))
//    println(Easy520().detectCapitalUse("ASD"))
//    println(Easy520().detectCapitalUse("AsD"))
//    println(Easy520().detectCapitalUse("aSD"))
}