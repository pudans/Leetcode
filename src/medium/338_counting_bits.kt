package medium

class Solution338 {

    fun countBits(num: Int): IntArray {
        return IntArray(num + 1) { Integer.bitCount(it) }
    }
}