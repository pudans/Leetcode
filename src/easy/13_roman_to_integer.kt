package easy

/**
 * 13. Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
 */

class Solution13 {

    fun romanToInt(s: String): Int {
        var result = 0
        s.forEachIndexed { index, char ->
            result +=  when (char) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
            if (index != 0) {
                val prevChar = s[index - 1]
                result -= when {
                    prevChar == 'I' && (char == 'V' || char == 'X') -> 2
                    prevChar == 'X' && (char == 'L' || char == 'C') -> 20
                    prevChar == 'C' && (char == 'D' || char == 'M') -> 200
                    else -> 0
                }
            }
        }
        return result
    }
}

fun main() {
    println(Solution13().romanToInt("III"))
    println(Solution13().romanToInt("IV"))
    println(Solution13().romanToInt("IX"))
    println(Solution13().romanToInt("LVIII"))
    println(Solution13().romanToInt("MCMXCIV"))
}