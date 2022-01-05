package easy

import DynamicProgrammingTopic
import MathTopic

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class Easy733 : MathTopic, DynamicProgrammingTopic {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val lastColor: Int = image[sr][sc]
        fill(image, newColor, sr, sc, lastColor)
        return image
    }

    private fun fill(
        image: Array<IntArray>,
        newColor: Int,
        i: Int,
        j: Int,
        lastColor: Int
    ) {
        if (i !in image.indices) return
        if (j !in image.first().indices) return
        if (image[i][j] == newColor) return
        if (image[i][j] != lastColor) return
        image[i][j] = newColor
        fill(image, newColor, i + 1, j, lastColor)
        fill(image, newColor, i - 1, j, lastColor)
        fill(image, newColor, i, j + 1, lastColor)
        fill(image, newColor, i, j - 1, lastColor)
    }
}

fun main() {
    println(
        Easy733().floodFill(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 0)), 1, 1, 2)
            .map { it.toList() }.map { it.toList() })
    println(Easy733().floodFill(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)), 0, 0, 2).map { it.toList() }
        .map { it.toList() })
}