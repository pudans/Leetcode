package medium


class Solution763 {

    fun partitionLabels(S: String): List<Int?>? {
        val last = IntArray(26)
        for (i in S.indices) {
            last[S[i] - 'a'] = i
        }
        var j = 0
        var anchor = 0
        val ans = ArrayList<Int>()
        for (i in S.indices) {
            j = Math.max(j, last[S[i] - 'a'])
            if (i == j) {
                ans.add(i - anchor + 1)
                anchor = i + 1
            }
        }
        return ans
    }

    fun partitionLabels1(S: String): List<Int> {
        val map = HashMap<Char, IntArray>()
        S.forEachIndexed { index, c ->
            val pair = map[c]
            if (pair == null) {
                map[c] = intArrayOf(index, index)
            } else {
                pair[1] = index
            }
        }

        map.entries.forEach {
            println("${it.key} ${it.value.toList()}")
        }

        val result = ArrayList<IntArray>()
        map.values.forEach {
            var found = false
            for (i in result.indices) {
                val sum = result[i]
                if ((it[0] > sum[0] && it[0] < sum[1])
                        || (it[1] > sum[0] && it[1] < sum[1])
                        || (sum[0] > it[0] && sum[0] < it[1])
                        || (sum[1] > it[0] && sum[1] < it[1])
                ) {
                    found = true
                    sum[0] = Math.min(sum[0], it[0])
                    sum[1] = Math.max(sum[1], it[1])
                    result.set(i, sum)
                }
            }
            if (!found) {
                result.add(it)
            }
        }

        result.forEach {
            println("${it.toList()} ${S.substring(it[0],it[1] + 1)}")
        }

        return result.map { it[1] - it[0] + 1}
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
//            val dd = Solution763().partitionLabels("ababcbacadefegdehijhklij")
//            val dd = Solution763().partitionLabels("eccbbbbdec")
            val dd = Solution763().partitionLabels("caedbdedda")
            println(dd)
        }
    }
}