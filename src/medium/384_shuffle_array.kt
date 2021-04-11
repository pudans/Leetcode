package medium

import kotlin.random.Random

class Solution384(
        private val nums: IntArray
) {
    private val cloned = nums.copyOf()

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return cloned
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val random = Random(System.nanoTime())
        val size = nums.size

        nums.forEachIndexed { index, i ->
            val swapPos = random.nextInt(size)
            val temp = nums[swapPos]
            nums[swapPos] = i
            nums[index] = temp
        }
        return nums
    }
}
