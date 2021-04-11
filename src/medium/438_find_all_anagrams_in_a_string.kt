package medium

class Solution438 {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        if (s.length < p.length) {
            return result
        }

        var dd = 0.0
        var pp = 0.0
        for (i in 0 until p.length) {
            dd += Math.sin(p[i].toDouble())
            pp += Math.sin(s[i].toDouble())
        }

        if (Math.abs(dd - pp) < 0.0000000001) {
            result.add(0)
        }

        for (i in 1..(s.length - p.length)) {
            println("$i ${i-1} ${i + p.length - 1}")

            pp -= Math.sin(s[i - 1].toDouble())
            pp += Math.sin(s[i + p.length - 1].toDouble())
            if (Math.abs(dd - pp) < 0.0000000001) {
                result.add(i)
            }
        }
        return result
    }

    fun hash(s: String, start: Int, end: Int): Double {
        var sum = 0.0
        for (i in start..end) {
            sum += Math.sin(s[i].toDouble())
        }
        return sum
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution438().findAnagrams("cbaebabacd", "abc")
            println(dd)
        }
    }
}