package medium

import StringTopic

/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character.
 * Then for each group, say the number of characters, then say the character.
 * To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 */

class Medium38: StringTopic {

    fun countAndSay(input: Int): String {
        if (input == 1) return "1"
        if (input == 2) return "11"
        if (input == 3) return "21"
        if (input == 4) return "1211"
        if (input == 5) return "111221"
        val sb = StringBuilder()

        val prevOutput = countAndSay(input - 1)
        // 1211 111221
        var count = 1
        for (i in 0 until prevOutput.length - 1) {
            if (prevOutput[i] == prevOutput[i + 1]) {
                count++
            } else {
                sb.append(count).append(prevOutput[i])
                count = 1
            }
        }
        sb.append(count).append(prevOutput[prevOutput.length - 1])
        return sb.toString()
    }
}

fun main() {
    println(Medium38().countAndSay(1))
    println(Medium38().countAndSay(4))
}