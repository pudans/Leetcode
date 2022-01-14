package medium

import GreedyTopic
import HashTableTopic
import TwoPointersTopic

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/
 *
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.
 */

class Medium763 : HashTableTopic, TwoPointersTopic, GreedyTopic {

    fun partitionLabels(S: String): List<Int> {
        val last = IntArray(26)
        for (i in S.indices) {
            last[S[i] - 'a'] = i
        }
        var j = 0
        var anchor = 0
        val ans = mutableListOf<Int>()
        for (i in S.indices) {
            j = maxOf(j, last[S[i] - 'a'])
            if (i == j) {
                ans.add(i - anchor + 1)
                anchor = i + 1
            }
        }
        return ans
    }
}

fun main() {
    println(Medium763().partitionLabels("ababcbacadefegdehijhklij"))
    println(Medium763().partitionLabels("eccbbbbdec"))
    println(Medium763().partitionLabels("caedbdedda"))
}