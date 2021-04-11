package easy

import kotlin.math.roundToInt

class Solution492 {

    fun constructRectangle(area: Int): IntArray {
        if (area == 0) {
            return intArrayOf(0,0)
        }
        var width = Math.sqrt(area.toDouble()).roundToInt()
        while(area % width != 0) {
            width--;
        }
        return intArrayOf(area / width, width)
    }
}

object Main492 {

    @JvmStatic
    fun main(args: Array<String>) {
        val dd = Solution492()

        for (i in 0..100) {
            val res = dd.constructRectangle(i)
            println("$i ${res[0]} ${res[1]} ${res[0]*res[1]>=i}")
        }
    }
}