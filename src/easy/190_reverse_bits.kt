package easy

class Solution190 {
    // you need treat n as an unsigned value
//    fun reverseBits(n: Int): Int {
//        var input = (if (n < 0) 2L * Int.MAX_VALUE + 2L + n else n).toLong()
//        val pows = LongArray(32)
//        val bytes = ByteArray(32)
//        var pow = 31
//        while (input != 0L || pow >= 0) {
//            val h = Math.pow(2.0, pow.toDouble()).toLong()
//            pows[pow] = h
//            if (input >= h) {
//                input -= h
//                bytes[pow] = 1
//            } else {
//                bytes[pow] = 0
//            }
//            pow -= 1
//        }
//        input = 0L
//        for (i in bytes.indices) {
//            if (bytes[31 - i] == 1.toByte()) {
//                input += pows[i]
//            }
//        }
//        return if (input > Int.MAX_VALUE) (input - 2L * Int.MAX_VALUE - 2L).toInt() else input.toInt()
//    }
}