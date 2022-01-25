package medium

import HeapTopic
import SortingTopic
import java.util.*


/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */

class Medium215 : SortingTopic, HeapTopic {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()
        nums.forEach {
            queue.add(it)
            if (queue.size > k) queue.remove()
        }
        return queue.element()
    }

    // mine
    fun findKthLargest1(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums[nums.size - k]
    }
}