package medium

import MathTopic
import StringTopic

/**
 * 1041. Robot Bounded In Circle
 * https://leetcode.com/problems/robot-bounded-in-circle/
 *
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.
Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */

class Medium1041 : StringTopic, MathTopic {

    fun isRobotBounded(instructions: String): Boolean {
        val position = longArrayOf(0L, 0L, 3L)
        repeat(instructions.length * 2) {
            go(instructions, position)
            if (position[0] == 0L && position[1] == 0L) return true
        }
        return false
    }

    fun go(instructions: String, position: LongArray) {
        instructions.forEach {
            when (it) {
                'L' -> position[2] = (position[2] - 1 + 4) % 4
                'R' -> position[2] = (position[2] + 1 + 4) % 4
                else -> {
                    when (position[2]) {
                        0L -> position[1]++
                        1L -> position[0]--
                        2L -> position[1]--
                        else -> position[0]++
                    }
                }
            }
        }
    }
}

fun main() {
    println(Medium1041().isRobotBounded("GGLLGG"))
    println(Medium1041().isRobotBounded("GG"))
    println(Medium1041().isRobotBounded("GL"))
    println(Medium1041().isRobotBounded("GLRLGLLGLGRGLGL"))
}