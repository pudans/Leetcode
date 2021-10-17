package easy

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */

class Easy283 {

    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var j = 0

        while (i < nums.size && j < nums.size) {
            if (nums[j] == 0) {
                j++

                while (j < nums.size) {
                    if (nums[j] != 0) {
                        break
                    } else {
                        j++
                    }
                }
            }
            if (j < nums.size) {
                nums[i] = nums[j]
                i++
                j++
            }

        }
        if (i < nums.size && j - 1 < nums.size) {
            for (g in i until j) {
                nums[g] = 0
            }
        }
    }
}

fun main() {
    var dd = intArrayOf(0,1,0,3,12)
    Easy283().moveZeroes(dd)
    println(dd.toList())

    dd = intArrayOf(0)
    Easy283().moveZeroes(dd)
    println(dd.toList())
}