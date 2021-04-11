package easy

class Solution119 {

    fun getRow(rowIndex: Int): List<Int> {
        val result = ArrayList<List<Int>>(rowIndex + 1)
        result.add(listOf(1))
        if (rowIndex == 0) {
            return result[0]
        }
        for (i in 1..rowIndex) {
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
        return result[rowIndex]
    }
}