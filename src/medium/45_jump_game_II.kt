package medium

class Solution45 {

    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentJumpEnd = 0
        var farthest = 0
        for (i in 0 until nums.size - 1) {
            farthest = Math.max(farthest, i + nums[i])
            if (i == currentJumpEnd) {
                jumps++
                currentJumpEnd = farthest
            }
        }
        return jumps
    }

    val mem = HashMap<Int, Int>()

    fun jump1(nums: IntArray): Int {
        return jump1(nums, 0, 0)
    }

    fun jump1(nums: IntArray, from: Int, count: Int): Int {

        if (mem.containsKey(from)) {
            return mem[from]!!
        }
        if (from == nums.size - 1) {
            return count
        }
        if (from > nums.size - 1) {
            return Int.MAX_VALUE
        }
        val range = nums[from]
        var result = Int.MAX_VALUE

        for (i in (from + range)..(from + 1)) {
            result = Math.min(result, jump1(nums, i, count + 1))
        }
        mem[from] = result
        return result
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution45()
//            val ff = dd.jump(intArrayOf(2,0,2,4,6,0,0,3))
//            val ff = dd.jump(intArrayOf(2,3,1,1,4))
//            val ff = dd.jump(intArrayOf(2,3,0,1,4))
            val ff = dd.jump(intArrayOf(1,2,1,1,1))
            println(dd.mem)
            println(ff)
        }
    }
}