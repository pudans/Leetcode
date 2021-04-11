package easy

class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>(numRows)
        if (numRows == 0) {
            return result
        }
        result.add(listOf(1))
        if (numRows == 1) {
            return result
        }
        for (i in 1 until numRows) {
            val inner = arrayOfNulls<Int>(i + 1)
            inner[0] = 1
            inner[i] = 1
            for (j in 1..(i/2)) {
                val t = result[i - 1][j - 1] + result[i - 1][j]
                inner[j] = t
                inner[i - j] = t
            }
            println(inner.toString())
            result.add(i, inner.toList() as List<Int>)
        }
        return result
    }
}