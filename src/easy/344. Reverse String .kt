package easy

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */

class Easy344 {

    fun reverseString(s: CharArray): Unit {
        for (i in 0 until s.size / 2) {
            s[i] = s[s.size - 1 - i].also { s[s.size - 1 - i] = s[i] }
        }
    }
}

fun main() {
    var dd = charArrayOf('h', 'e', 'l', 'l', 'o')
    Easy344().reverseString(dd)
    println(dd)

    dd = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    Easy344().reverseString(dd)
    println(dd)
}