package easy

abstract class VersionControl {
    open fun isBadVersion(version: Int): Boolean = version >= 1702766719

    abstract fun firstBadVersion(n: Int) : Int
}


class Solution278: VersionControl() {

    var minBadVersion = Int.MAX_VALUE

    override fun firstBadVersion(n: Int) : Int {
        return findInRange(IntRange(1,n))
    }

    fun findInRange(range: IntRange): Int {
        if (range.first == range.last) {
            if (isBadVersion(range.first)) {
                return range.first
            } else {
                return minBadVersion
            }
        } else {
            val mid = ((range.first.toLong() + range.last.toLong()) / 2L).toInt()
            val result = isBadVersion(mid)
            println("$mid $result ${range.first} ${range.last}")
            if (!result) {
                return findInRange(
                        IntRange(
                                Math.min(mid + 1, range.last),
                                range.last
                        )
                )
            } else {
                minBadVersion = Math.min(minBadVersion, mid)
                return findInRange(
                        IntRange(
                                range.first,
                                Math.max(range.first, mid - 1)
                        )
                )
            }
        }
    }
}

object Main278 {

    @JvmStatic
    fun main(args: Array<String>) {
        val dd = Solution278()
        println(dd.firstBadVersion(
                2126753390))
    }
}