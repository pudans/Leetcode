package easy

class Solution69 {

    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        var last = 0.0
        var res = 1.0
        while (res != last) {
            last = res
            res = (res + x / res) / 2
        }
        return res.toInt()
    }
}