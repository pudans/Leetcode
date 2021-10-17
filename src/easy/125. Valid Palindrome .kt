package easy

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */

class Easy125 {

    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            when {
                !s[i].isLetterOrDigit() -> i++
                !s[j].isLetterOrDigit() -> j--
                s[i].equals(s[j], ignoreCase = true) -> { i++; j-- }
                else -> return false
            }
        }
        return true
    }
}

fun main() {
    println(Easy125().isPalindrome("A man, a plan, a canal: Panama"))
    println(Easy125().isPalindrome("race a car"))
}