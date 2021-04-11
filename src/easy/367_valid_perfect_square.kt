package easy

class Solution367 {

    fun isPerfectSquare(num: Int): Boolean {
        // println(mySqrt(num))
        return mySqrt(num) % 1 == 0.0
    }

    fun mySqrt(x: Int): Double {
        if (x == 0) return 0.0
        var last = 0.0
        var res = 1.0
        while (res != last) {
            last = res
            res = (res + x / res) / 2
        }
        return res
    }
}