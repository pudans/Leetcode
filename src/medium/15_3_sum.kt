package medium

import java.lang.Math.tanh
import java.util.ArrayList

import java.util.Arrays

import java.util.HashSet




class Solution15 {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return ArrayList<ArrayList<Int>>()
        }
        nums.sort()
        val set = HashSet<List<Int>>()
        for (i in 0 until nums.size - 2) {
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        set.add(listOf(nums[i], nums[j], nums[k]))
                        j++
                        k--
                    }
                    sum > 0 -> k--
                    else -> j++
                }
            }
        }
        return ArrayList(set)
    }

//    fun threeSum1(nums: IntArray): List<List<Int>> {
//        if (nums.size < 3) {
//            return ArrayList<ArrayList<Int>>()
//        }
//        nums.sort()
//        val result = ArrayList<List<Int>>()
//        for (i in 0 until nums.size - 2) {
//            var j = i + 1
//            var k = nums.size - 1
//            while (j < k) {
////                println("$i $j $k")
//                val sum = nums[i] + nums[j] + nums[k]
//                when {
//                    sum == 0 -> {
//                        result.add(listOf(nums[i], nums[j], nums[k]))
//                        j++
//                        k--
//                    }
//                    sum > 0 -> k--
//                    else -> j++
//                }
//            }
//        }
//        return result
//    }
//
//    fun threeSum2(nums: IntArray): List<List<Int>> {
//        val set = HashSet<List<Int>>()
//        for (i in 0..(nums.size - 3)) {
//            for (j in (i+1)..(nums.size - 2)) {
//                for (z in (j+1)..(nums.size - 1)) {
////                    println("$i $j $z")
//                    if (nums[i] + nums[j] + nums[z] == 0) {
//                        set.add(listOf(nums[i], nums[j], nums[z]))
//                    }
//                }
//            }
//        }
//        return ArrayList(set)
//    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution15().threeSum(intArrayOf(-1,0,1,2,-1,-4))
            println(dd)

//            val dd1 = Solution15().threeSum1(intArrayOf(-1,0,1,2,-1,-4))
//            println(dd1)
//
//            val dd2 = Solution15().threeSum2(intArrayOf(-1,0,1,2,-1,-4))
//            println(dd2)
        }
    }
}