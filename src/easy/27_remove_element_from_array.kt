package easy

class Solution27 {

    fun removeElement(nums: IntArray, `val`: Int): Int {

        var position = 0
        var result = nums.size
        nums.forEach {
            if (it == `val`) {
                result--

            } else {
                nums[position] = it
                position++
            }
        }
        return result
    }
}