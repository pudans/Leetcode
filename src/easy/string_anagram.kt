package easy

fun stringAnagram(dictionary: Array<String>, query: Array<String>): Array<Int> {
    return Array<Int>(query.size) { index ->
        val first = query[index]
        var resultQuery = 0
        dictionary.forEach { second ->
            val isAnagram = when {
                first.length != second.length -> false
                // first.length == 0 -> first[0].toByte() == second[0].toByte()
                else -> {
                    var result0: Int = 0
                    // for (i in 0 until first.length) {
                    //     result0 = result0 +
                    //         first[i].toByte().toInt() - 128 -
                    //         second[i].toByte().toInt() - 128
                    // }
                    result0 == 0
                }
            }
            resultQuery += if (isAnagram) 1 else 0
        }
        resultQuery
    }
}


fun isAnagram(first: String, second: String): Boolean {
    return false
    // if (first.length != second.length) {
    //     return false
    // }
    // if (first.length == 0) {
    //     return (first[0].toByte() == second[0].toByte())

    // } else {

    // var result0: Int = 0
    // var result1: Long = 0
    // var result2: Long = 0

    // for (i in 0 until first.length) {
    // result1 = result1 + Math.pow(first[i].toByte().toDouble(), 2.toDouble()).toLong()
    // result2 = result2 + Math.pow(second[i].toByte().toDouble(), 2.toDouble()).toLong()
    // result1 = result1 + first[i].toByte().toLong()
    // result2 = result2 + second[i].toByte().toLong()

    // result0 = result0 +
    // Math.pow(first[i].toByte().toDouble(), 2.toDouble()).toInt() -
    // Math.pow(second[i].toByte().toDouble(), 2.toDouble()).toInt()

    //      result0 = result0 +
    //     first[i].toByte().toInt() - 128 -
    //     second[i].toByte().toInt() - 128
    // }
    // return result1 == result2
    // return result0 == 0
    // }
}