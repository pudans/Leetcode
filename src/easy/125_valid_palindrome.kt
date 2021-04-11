package easy

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1

        while (i < j) {

            if (s[i].isLetterOrDigit()) {
                if (s[j].isLetterOrDigit()) {
                    if (s[i].toLowerCase() == s[j].toLowerCase()) {
                        i++
                        j--
                    } else {
                        return false
                    }
                } else {
                    j--
                }
            } else {
                i++
            }
        }
        return true
    }
}