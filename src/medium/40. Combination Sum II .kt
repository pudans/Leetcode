package medium

import ArraysTopic
import BacktrackingTopic
import java.util.*
import kotlin.collections.ArrayList

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum/
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
 */

class Medium40 : ArraysTopic, BacktrackingTopic {

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val results = ArrayList<List<Int>>()
        backtrack(candidates.sortedArray(), LinkedList<Int>(), target, 0, results)
        return results
    }

    private fun backtrack(
        candidates: IntArray,
        comb: LinkedList<Int>,
        remain: Int, curr: Int,
        results: ArrayList<List<Int>>
    ) {
        if (remain == 0) {
            // copy the current combination to the final list.
            results.add(ArrayList(comb))
            return
        }
        for (nextCurr in curr until candidates.size) {
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1]) continue
            val pick = candidates[nextCurr]
            // optimization: early stopping
            if (remain - pick < 0) break
            comb.addLast(pick)
            backtrack(candidates, comb, remain - pick, nextCurr + 1, results)
            comb.removeLast()
        }
    }

    // mine TLE
    fun combinationSum22(candidates: IntArray, target: Int): List<List<Int>> {
        val result = HashSet<List<Int>>()
        for (i in candidates.indices) {
            isCombinate(candidates, target, i, 0, ArrayList(), result)
        }
        return result.toList()
    }

    fun isCombinate(
        candidates: IntArray,
        target: Int,
        index: Int,
        value: Int,
        items: ArrayList<Int>,
        result: HashSet<List<Int>>
    ) {
        if (index == candidates.size) return
        val newValue = value + candidates[index]
        items.add(candidates[index])
        if (newValue == target) {
            result.add(items.sorted())
        } else {
            if (newValue < target) {
                for (i in index + 1 until candidates.size) {
                    isCombinate(candidates, target, i, newValue, ArrayList(items), result)
                }
            }
        }
    }
}

fun main() {
    println(Medium40().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(Medium40().combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
    println(Medium40().combinationSum2(intArrayOf(2, 3, 6, 7), 7))
    println(Medium40().combinationSum2(intArrayOf(2, 3, 5), 8))
    println(Medium40().combinationSum2(intArrayOf(2), 1))
}