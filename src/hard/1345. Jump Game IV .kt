package hard

import ArraysTopic
import BFSTopic
import HashTableTopic
import java.util.*


/**
 * 1345. Jump Game IV
 * https://leetcode.com/problems/jump-game-iv/
 *
Given an array of integers arr, you are initially positioned at the first index of the array.
In one step you can jump from index i to index:
i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.
Notice that you can not jump outside of the array at any time.

 BULLSHIT
 */

class Hard1345 : ArraysTopic, HashTableTopic, BFSTopic {

    fun minJumps(arr: IntArray): Int {
        if (arr.size <= 1) return 0
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (i in arr.indices) {
            graph.computeIfAbsent(arr[i]) { v: Int? -> LinkedList() }.add(i)
        }
        var curs: MutableList<Int> = LinkedList() // store current layer
        curs.add(0)
        val visited: MutableSet<Int> = HashSet()
        var step = 0

        // when current layer exists
        while (curs.isNotEmpty()) {
            val nex: MutableList<Int> = LinkedList()

            // iterate the layer
            for (node in curs) {
                // check if reached end
                if (node == arr.lastIndex) return step

                // check same value
                for (child in graph[arr[node]]!!) {
                    if (!visited.contains(child)) {
                        visited.add(child)
                        nex.add(child)
                    }
                }

                // clear the list to prevent redundant search
                graph[arr[node]]!!.clear()

                // check neighbors
                if (node + 1 < arr.size && !visited.contains(node + 1)) {
                    visited.add(node + 1)
                    nex.add(node + 1)
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1)
                    nex.add(node - 1)
                }
            }
            curs = nex
            step++
        }
        return -1
    }

    // TLE, mine
    fun minJumps(arr: IntArray, pos: Int = 0, jumps: Int = 0, vizited: HashSet<Int> = HashSet()): Int {
        if (vizited.contains(pos)) return Int.MAX_VALUE
        if (pos == arr.lastIndex) return jumps
        vizited.add(pos)
        val step1 = minJumps(arr, pos + 1, jumps + 1, HashSet(vizited))
        val step2 = if (pos > 0) minJumps(arr, pos - 1, jumps + 1, HashSet(vizited)) else Int.MAX_VALUE
        var min = minOf(step1, step2)
        arr.forEachIndexed { index, i ->
            if (index != pos && i == arr[pos]) {
                min = minOf(min, minJumps(arr, index, jumps + 1, HashSet(vizited)))
            }
        }
        return min
    }
}

fun main() {
    println(Hard1345().minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404)))
    println(Hard1345().minJumps(intArrayOf(7)))
    println(Hard1345().minJumps(intArrayOf(7, 6, 9, 6, 9, 6, 9, 7)))

}