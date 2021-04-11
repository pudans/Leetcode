package medium

import kotlin.math.max

class Solution3 {

    fun lengthOfLongestSubstring(s: String): Int {
        var map = HashMap<Char, Int>()
        var result = 0
        for (i in s.indices) {
            val dd = map[s[i]]
            if (dd == null) {
                map[s[i]] = i
            } else {
                result = max(result, map.size)
                map = map.filterTo(HashMap<Char, Int>()) { dd < it.value }
                map[s[i]] = i
            }
        }
        result = max(result, map.size)
        return result
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution3().lengthOfLongestSubstring("dvdf"))
        }
    }
}