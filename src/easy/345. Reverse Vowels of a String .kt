package easy

/**
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 */

class Easy365 {

    fun reverseVowels(s: String): String {
        var i = 0
        var j = s.length - 1
        var leftVowelIndex = -1
        val result = s.toCharArray()
        while (i <= j) {
            if (leftVowelIndex < 0) {
                if (result[i].isVowel()) {
                    leftVowelIndex = i
                }
                i++
            } else {
                if (result[j].isVowel()) {
                    val temp = result[leftVowelIndex]
                    result[leftVowelIndex] = result[j]
                    result[j] = temp
                    leftVowelIndex = -1
                }
                j--
            }
        }
        return String(result)
    }

    private fun Char.isVowel(): Boolean =
        when(lowercaseChar()) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }
}

fun main() {
    println(Easy365().reverseVowels("hello"))
    println(Easy365().reverseVowels("leetcode"))
}