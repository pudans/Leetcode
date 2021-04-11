package easy

class Solution242 {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        var sum1: Double = 0.0
        var sum2: Double = 0.0
        for (i in s.indices) {
            sum1 += Math.sin (s[i].toDouble())
            sum2 += Math.sin (t[i].toDouble())
        }
        return Math.abs(sum1 - sum2) < 0.0000000001
    }
}