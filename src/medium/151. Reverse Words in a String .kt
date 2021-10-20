package medium

/**
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */

class Medium151 {

    fun reverseWords(s: String): String {
        var wordIndex = 0
        val builder = StringBuilder()
        s.forEach { char ->
            when {
                char == ' ' && wordIndex != 0 -> wordIndex = 0
                char != ' ' -> {
                    if (wordIndex == 0 && builder.isNotEmpty()) {
                        builder.insert(0, ' ')
                    }
                    builder.insert(wordIndex, char)
                    wordIndex++
                }
            }
        }
        return builder.toString()
    }
}

fun main() {
    println(Medium151().reverseWords("the sky is blue"))
    println(Medium151().reverseWords("  hello world  "))
    println(Medium151().reverseWords("a good   example"))
    println(Medium151().reverseWords("  Bob    Loves  Alice   "))
    println(Medium151().reverseWords("Alice does not even like bob"))
}