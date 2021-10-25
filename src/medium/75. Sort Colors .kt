package medium

import ArraysTopic
import SortingTopic
import TwoPointersTopic

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */

class Medium75: ArraysTopic, TwoPointersTopic, SortingTopic {

    fun sortColors(nums: IntArray) {
        var zeros = -1
        var ones = -1
        var twos = -1

        nums.forEachIndexed { index, i ->
            if (i == 0) {
                if (zeros == -1) {
                    zeros = 0
                }
                if (ones != -1) {
                    nums[ones] = 0
                    ones++
                    nums[ones] = 1
                }
                if (twos != -1) {
                    if (ones != -1) {
                        nums[twos] = 1
                    } else {
                        nums[twos] = 0
                    }
                    twos++
                    nums[twos] = 2
                }
            }

            if (i == 1) {
                if (ones == -1) {
                    ones = zeros + 1
                }
                nums[ones] = 1
                if (twos != -1) {
                    twos++
                    nums[twos] = 2
                }
            }

            if (i == 2) {
                if (twos == -1) {
                    twos = when {
                        ones != -1 -> ones + 1
                        zeros != -1 -> zeros + 1
                        else -> 0
                    }
                }
                nums[twos] = 2
            }
            nums[index] = when {
                twos != -1 -> 2
                ones != -1 -> 1
                else -> 0
            }
            println("$zeros $ones $twos ${nums.toList()} ")
        }
    }
}

fun main() {
    println(Medium75().sortColors(intArrayOf(2,0,2,1,1,0)))
    println(Medium75().sortColors(intArrayOf(2,0,1)))
    println(Medium75().sortColors(intArrayOf(0)))
    println(Medium75().sortColors(intArrayOf(1)))
}