package easy

class Solution168 {

    val data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    fun convertToTitle(num: Int): String {
        var dd = num
        var result = ""
        while (dd > 26) {
            var bb = dd / 26
            val ff = dd - (bb * 26)
            result += if (ff == 0) {
                bb--
                (data.last().toString())
            } else {
                (data[ff - 1].toString())
            }
            dd = bb
        }
        result += (data[dd - 1].toString())

        return result.reversed()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution168().convertToTitle(2000000000)
            println(dd)
        }
    }
}