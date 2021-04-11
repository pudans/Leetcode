package medium

class Solution49 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = ArrayList<List<String>>()

        if (strs.isEmpty()) {
            return result
        }
        if (strs.size == 1) {
            result.add(listOf(strs[0]))
            return result
        }

        for (i in strs.indices) {
            val str = strs[i]
            if (str != "й") {
                val resList = ArrayList<String>()
                resList.add(str)

                for (j in (i + 1) until strs.size) {
                    if (isAnagram(str, strs[j])) {
                        resList.add(strs[j])
                        strs[j] = "й"
                    }
                }
                result.add(resList)
            }
        }

        return result
    }

//    fun isAnagram(first: String, second: String): Boolean =
//            when {
//                first.length != second.length -> false
//                first.isEmpty() -> true
//                first.length == 1 -> first[0].toByte() == second[0].toByte()
//                else -> {
//                    var result0 = 0
//                    for (i in first.indices) {
//                        result0 = result0 +
//                                first[i].toByte() -
//                                second[i].toByte()
//                    }
//                    result0 == 0
//                }
//            }

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