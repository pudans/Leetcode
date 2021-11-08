package medium

import kotlin.random.Random

/**
 * 384. Shuffle an Array
 * https://leetcode.com/problems/shuffle-an-array/
 *
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
Implement the Solution class:
Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.
 */

class Medium384(private val nums: IntArray) {

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
