package easy

import ArraysTopic
import HeapTopic

/**
 * 1046. Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 */

class Easy1046: ArraysTopic, HeapTopic {

    lateinit var stoneList: MutableList<Int>

    fun lastStoneWeight(stones: IntArray): Int {
        stoneList = stones.toMutableList()
        while (stoneList.size > 1) {
            findToStones()
        }
        return stoneList.getOrElse(0) { 0 }
    }

    private fun findToStones() {
        var stone1Index = 0
        var stone2Index = 1
        if (stoneList.size > 2) {
            for (i in 2 until stoneList.size) {
                if (stoneList[i] > stoneList[stone1Index]) {
                    if (stoneList[stone2Index] < stoneList[stone1Index]) {
                        stone2Index = stone1Index
                    }
                    stone1Index = i
                } else if (stoneList[i] > stoneList[stone2Index]) {
                    stone2Index = i
                }
            }
        }
        smashStones(stone1Index, stone2Index)
    }

    private fun smashStones(stone1Index: Int, stone2Index: Int) {
        if (stoneList[stone1Index] == stoneList[stone2Index]) {
            if (stone1Index > stone2Index) {
                stoneList.removeAt(stone1Index)
                stoneList.removeAt(stone2Index)
            } else {
                stoneList.removeAt(stone2Index)
                stoneList.removeAt(stone1Index)
            }
        } else if (stoneList[stone1Index] > stoneList[stone2Index]) {
            stoneList[stone1Index] = stoneList[stone1Index] - stoneList[stone2Index]
            stoneList.removeAt(stone2Index)
        } else {
            stoneList[stone2Index] = stoneList[stone2Index] - stoneList[stone1Index]
            stoneList.removeAt(stone1Index)
        }
    }
}

fun main() {
    println(Easy1046().lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    println(Easy1046().lastStoneWeight(intArrayOf(1)))
}