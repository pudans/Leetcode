package medium

import ArraysTopic
import MathTopic
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

class Medium384 : ArraysTopic, MathTopic {

    class Solution(private val nums: IntArray) {

        private val cloned = nums.copyOf()

        /** Resets the array to its original configuration and return it. */
        fun reset(): IntArray = nums

        /** Returns a random shuffling of the array. */
        fun shuffle(): IntArray =
            cloned.also { array ->
                val random = Random(System.nanoTime())
                repeat(array.size) { index ->
                    val swapPos = random.nextInt(array.size)
                    array[index] = array[swapPos].also { array[swapPos] = array[index] }
                }
            }
    }
}

fun main() {
    val task = Medium384.Solution(intArrayOf(1,2,3))
    println(task.shuffle().toList())
    println(task.reset().toList())
    println(task.shuffle().toList())
}
