package medium

class Solution75 {

    // not worked

    fun sortColors2(nums: IntArray): Unit {
        var zeros = 0
        var ones = 0
        var twos = 0
        nums.forEach {
            when(it) {
                0 -> zeros++
                1 -> ones++
                2 -> twos++
            }
        }
        nums.forEachIndexed { index, i ->
            when {
                index < zeros -> nums[index] = 0
                index < zeros + ones -> nums[index] = 1
                index < zeros + ones + twos -> nums[index] = 2
            }
        }
    }

    fun sortColors(nums: IntArray): Unit {
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