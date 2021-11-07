package medium

import HashTableTopic

/**
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/
 *
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */

class Medium454 : HashTableTopic {

    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var result = 0

        val map = HashMap<Int,Int>()
        A.forEach { a ->
            B.forEach { b ->
                val key = a + b
                map.set(key, map.getOrDefault(key, 0) + 1)
            }
        }

        C.forEach { c ->
            D.forEach { d ->
                val key = -(c + d)
                if (map.containsKey(key)) {
                    result += map.get(key)!!
                }
            }
        }

        return result
    }
}