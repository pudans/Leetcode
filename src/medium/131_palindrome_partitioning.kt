package medium

import kotlin.collections.ArrayList

class Solution131 {

    fun partition(s: String): List<List<String>>? {
        val res = ArrayList<List<String>>()
        exploreAndBacktrack(s, 0, res, ArrayList())
        return res
    }

    private fun exploreAndBacktrack(s: String, idx: Int, res: ArrayList<List<String>>, buildUp: ArrayList<String>) {
        if (idx == s.length) {
            res.add(ArrayList(buildUp))
        } else {
            for (i in idx until s.length) {
                val curr = s.substring(idx, i + 1)
                if (isPalindrome(curr)) {
                    buildUp.add(curr)
                    exploreAndBacktrack(s, idx + curr.length, res, buildUp)
                    buildUp.removeAt(buildUp.size - 1)
                }
            }
        }
    }

    private fun isPalindrome(s: String): Boolean {
        for (i in 0 until s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}