package medium

class Solution17 {

    fun letterCombinations(digits: String): List<String> {
        val map = mapOf(Pair(2,"abc"),Pair(3,"def"),Pair(4,"ghi"),Pair(5,"jkl"),Pair(6,"mno"),Pair(7,"pqrs"),Pair(8,"tuv"),Pair(9,"wxyz"))
        val result = ArrayList<String>()

        if (digits.isEmpty()) {
            return result
        }

        val number: Int = digits.fold(1) { acc, c -> acc * map.getOrDefault(c.toString().toInt(),"").length }

        var gg = number
        val mn = IntArray(digits.length) {
            gg = gg / map.getOrDefault(digits[it].toString().toInt(),"").length
            return@IntArray gg
        }

        for (i in 0 until number) {
            var res1 = ""
            digits.forEachIndexed { index, char ->
                map.getOrDefault(char.toString().toInt(),"").takeIf { it.isNotEmpty() }?.let {
                    val tt = i / mn[index]
                    res1 += it.get(tt % it.length)
                }
            }
            result.add(res1)
        }

        return result
    }
}