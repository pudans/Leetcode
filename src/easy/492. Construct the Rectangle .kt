package easy

import kotlin.math.roundToInt

/**
 * 492. Construct the Rectangle
 * https://leetcode.com/problems/construct-the-rectangle/
 *
 * A web developer needs to know how to design a web page's size.
 * So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page,
 * whose length L and width W satisfy the following requirements:
 *
 * The area of the rectangular web page you designed must equal to the given target area.
 * The width W should not be larger than the length L, which means L >= W.
 * The difference between length L and width W should be as small as possible.
 * Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.
 */

class Easy492 {

    fun constructRectangle(area: Int): IntArray {
        if (area == 0) return intArrayOf(0,0)
        var width = Math.sqrt(area.toDouble()).roundToInt()
        while (area % width != 0) { width-- }
        return intArrayOf(area / width, width)
    }
}

fun main() {
    for (i in 0..100) {
        val res = Easy492().constructRectangle(i)
        println("$i ${res[0]} ${res[1]} ${res[0]*res[1]>=i}")
    }
}