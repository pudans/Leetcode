package medium

class Solution5 {

    private lateinit var str: String

    fun longestPalindrome(s: String): String {
        str = s
        if (s.length == 1) {
            return s
        }
        var maxResult = 0
        var result = ""
        for (i in 1 until s.length) {
            val curUnevenMaxResult = getUnevenMaxPalindrome(i)
            val curEvenMaxResult = getEvenMaxPalindrome(i)

            if (curUnevenMaxResult > maxResult && curUnevenMaxResult > curEvenMaxResult) {
                maxResult = curUnevenMaxResult
                result = str.substring(i - curUnevenMaxResult / 2, i + 1 + curUnevenMaxResult / 2)
            }

            if (curEvenMaxResult > maxResult && curEvenMaxResult > curUnevenMaxResult) {
                maxResult = curEvenMaxResult
                result = str.substring(i - curEvenMaxResult / 2, i + curEvenMaxResult / 2)
            }
            println("${str[i]} $result")
        }
        return result
    }

    fun getUnevenMaxPalindrome(i: Int): Int {
        var start = i - 1
        var end = i + 1
        var result = 1
        while (start >= 0 && end < str.length) {
            if (str[start] != str[end]) {
                return result
            } else {
                start--
                end++
                result+=2
            }
        }
        return result
    }

    fun getEvenMaxPalindrome(i: Int): Int {
        var start = i - 1
        var end = i
        var result = 0
        while (start >= 0 && end < str.length) {
            if (str[start] != str[end]) {
                return result
            } else {
                start--
                end++
                result+=2
            }
        }
        return result
    }

    fun isPalindrome(str: String): Boolean {
        for (i in 0 until (str.length / 2)) {
            if (str[i] != str[str.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}