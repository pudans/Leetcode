package medium

import ArraysTopic
import HashTableTopic


/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
You are given a list of songs where the ith song has a duration of time[i] seconds.
Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 */

class Medium1010: ArraysTopic, HashTableTopic {

    fun numPairsDivisibleBy60(time: IntArray): Int {
        val array = IntArray(60)
        for (i in time.indices) {
            array[time[i] % 60]++
        }
        var result = array[0] * (array[0] - 1) / 2 + array[30] * (array[30] - 1) / 2
        for (i in 1..29) {
            result += array[i] * array[60 - i]
        }
        return result
    }

    fun numPairsDivisibleBy601(time: IntArray): Int {
        var result = 0
        for (i in 0 until time.lastIndex) {
            for (j in (i + 1) until time.size) {
                if ((time[i] + time[j]) % 60 == 0) {
                    result++
                }
            }
        }
        return result
    }
}

fun main() {
    println(Medium1010().numPairsDivisibleBy60(intArrayOf(30,20,150,100,40)))
    println(Medium1010().numPairsDivisibleBy60(intArrayOf(60,60,60)))
}