package medium

class Solution62 {

//    fun uniquePaths(m: Int, n: Int): Int {
//        return getPath(m,n,0,0) + 1
//    }
//
//    private fun getPath(m: Int, n: Int, currM: Int, currN: Int): Int {
//        if (currM < m - 1 && currN < n - 1) {
//            return 1 + getPath(m,n,currM + 1, currN) + getPath(m,n,currM, currN + 1)
//        } else {
//            return 0
//        }
//    }

    fun uniquePaths(m: Int, n: Int): Int {
        val array = Array(m + 1) { IntArray(n + 1) { 0 } }
        array[1][0] = 1
        for (i in 1 .. m) {
            for (j in 1 .. n) {
                array[i][j] = array[i][j-1] + array[i-1][j];
            }
        }
        return array[m][n];
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution62().uniquePaths(7,3)
            println(dd)
        }
    }
}