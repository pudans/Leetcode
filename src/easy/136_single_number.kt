package easy

class Solution136 {

    fun singleNumber(nums: IntArray): Int {
        val set = HashMap<Int,Boolean>()
        nums.forEach {
            if (set[it] == true) {
                set.remove(it)
            } else {
                set[it] = true
            }
        }
        return set.keys.toIntArray()[0]
    }
}