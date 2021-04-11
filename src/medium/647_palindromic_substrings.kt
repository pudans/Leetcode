package medium

class Solution647 {

    fun countSubstrings(str: String): Int {
        var result = 0
        for (i in str.indices) {
            for (j in i until str.length) {
                if (isPalindrom(str, i, j)) {
                    result++
                }
            }
        }
        return result
    }

    fun isPalindrom(str: String, start: Int, end: Int): Boolean {
        if (start == end) return true
        val middle = Math.ceil((end - start).toDouble() / 2f).toInt()

        for (i in 0 until middle) {
            if (str[start + i] != str[end - i]) {
                return false
            }
        }
        println("$str $start $end $middle")
        return true
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution647().countSubstrings("aaa")
            println(dd)
        }
    }
}