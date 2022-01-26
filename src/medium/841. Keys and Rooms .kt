package medium

import BFSTopic
import DFSTopic
import java.util.*

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 *
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
return true if you can visit all the rooms, or false otherwise.
 */

class Medium841 : DFSTopic, BFSTopic {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        traverse(0, rooms, visited)
        return visited.all { it }
    }

    private fun traverse(i: Int, rooms: List<List<Int>>, visited: BooleanArray) {
        if (visited[i]) return
        visited[i] = true
        rooms[i].forEach { traverse(it, rooms, visited) }
    }
}

fun main() {
    println(Medium841().canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
    println(Medium841().canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))
}