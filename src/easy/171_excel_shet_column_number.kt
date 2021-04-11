package easy

class Solution171 {

    fun titleToNumber(s: String): Int {
        var result = 0
        for (i in s.length - 1 downTo 0) {
            val d = Math.pow(
                    26.toDouble(),
                    (s.length - 1 - i).toDouble()
            ).toInt() * (s[i].toInt() - 64)
            result += d
        }
        return result
    }
}