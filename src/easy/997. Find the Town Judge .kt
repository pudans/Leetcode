package easy

import HashTableTopic
import java.util.*

/**
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 *
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */

class Easy997 : HashTableTopic {

    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1) return 1
        val set = HashMap<Int, Int>()
        trust.forEach {
            set[it[1]] = set.getOrDefault(it[1], 0) + it[0]
            set[it[0]] = Int.MIN_VALUE
        }
        fun gg(n: Int): Int = if (n == 0) 0 else n + gg(n - 1)
        val nn = gg(n)
        set.entries.forEach {
            if (it.value + it.key == nn) return it.key
        }
        return -1
    }
}

fun main() {
    println(Easy997().findJudge(2, arrayOf(intArrayOf(1, 2))))
    println(Easy997().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
    println(Easy997().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1))))
    println(
        Easy997().findJudge(
            4, arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(4, 3))
        )
    )
}