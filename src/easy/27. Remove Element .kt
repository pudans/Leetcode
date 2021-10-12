package easy

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 */

class Easy27 {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var position = 0
        nums.forEach {
            if (it != `val`) {
                nums[position] = it
                position++
            }
        }
        return nums.size - (nums.size - position)
    }
}

fun main() {
    val example1 = intArrayOf(3,2,2,3)
    println(Easy27().removeElement(example1, 3))
    println(example1.toList())

    val example2 = intArrayOf(0,1,2,2,3,0,4,2)
    println(Easy27().removeElement(example2, 2))
    println(example2.toList())
}