package medium

import GreedyTopic
import SortingTopic
import StringTopic

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 *
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

class Medium179 : StringTopic, GreedyTopic, SortingTopic {

    fun largestNumber(nums: IntArray): String? {
        val asStrs = Array(nums.size) { nums[it].toString() }
        val comparator = Comparator { a: String, b: String ->
            (b + a).compareTo(a + b)
        }
        asStrs.sortWith(comparator)
        if (asStrs[0] == "0") {
            return "0"
        }
        return asStrs.reduce { acc, s -> acc + s }
    }

    fun largestNumber2(nums: IntArray): String {
        if (nums.isEmpty()) {
            return ""
        }
        val buildUp = HashMap<Int, String>()

        val comparator: Comparator<in Int> = Comparator { n1: Int, n2: Int ->
            if (n1.toString().length != n2.toString().length) {
                var str1 = buildUp.getOrDefault(n1, n1.toString())
                var str2 = buildUp.getOrDefault(n2, n2.toString())
                val maxLen = Math.max(str1.length, str2.length)
                while (str1.length < maxLen) {
                    str1 += str1[str1.length - 1].toString()
                }
                while (str2.length < maxLen) {
                    str2 += str2[str2.length - 1].toString()
                }
                println("$n1 $n2 $maxLen $str1 $str2")
                buildUp.put(n1, str1)
                buildUp.put(n2, str2)
                Integer.parseInt(str2) - Integer.parseInt(str1)
            } else {
                n2 - n1
            }
        }

        val list = nums.sortedWith(comparator)
        println(list)
        if (list.first() == 0) {
            return 0.toString()
        }

        val result = list.map { it.toString() }.reduce { acc, s -> acc + s }
        return result
    }
}