package medium

import ArraysTopic
import BacktrackingTopic

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */

class Medium39: ArraysTopic, BacktrackingTopic {

    val result = ArrayList<List<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        for (i in candidates.indices) {
            isCombinate(i, candidates, 0, target, ArrayList())
        }
        return result
    }

    fun isCombinate(
        index: Int,
        candidates: IntArray,
        value: Int,
        target: Int,
        items: ArrayList<Int>
    ) {
        if (index == candidates.size) {
            return
        }
        val newValue = value + candidates[index]
        items.add(candidates[index])
        if (newValue == target) {
            result.add(ArrayList(items))
            return
        }

        if (newValue < target) {
            for (i in index until candidates.size) {
                isCombinate(i, candidates, newValue, target, ArrayList(items))
            }
        }
    }
}

fun main() {
    println(Medium39().combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(Medium39().combinationSum(intArrayOf(2, 3, 5), 8))
    println(Medium39().combinationSum(intArrayOf(2), 1))
}