package medium

class Solution39 {

    val result = ArrayList<List<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        for (i in candidates.indices) {
            isCombinate(i, candidates, 0, target, ArrayList())
        }
        return result
    }

    fun isCombinate(
            index: Int,
            candidates: IntArray,
            value: Int,
            target: Int,
            items: ArrayList<Int>
    ) {
        if (index == candidates.size) {
            return
        }
        val newValue = value + candidates[index]
        items.add(candidates[index])
        if (newValue == target) {
            result.add(ArrayList(items))
            return
        }

        if (newValue < target) {
            for (i in index until candidates.size) {
                isCombinate(i, candidates, newValue, target, ArrayList(items))
            }
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
//            val dd = Solution39().combinationSum(intArrayOf(2,3,5), 8)
//            val dd = Solution39().combinationSum(intArrayOf(2,3,6,7), 7)
//            val dd = Solution39().combinationSum(intArrayOf(2), 1)
            val dd = Solution39().combinationSum(intArrayOf(1), 1)
//            val dd = Solution39().combinationSum(intArrayOf(3,5,8), 11)
            println(dd)
        }
    }
}