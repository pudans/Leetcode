
class MyHashMap<Key, Value> {

    class ListNode<Value>(val data: Value?) {
        var next: ListNode<Value>? = null
    }

    var capacity = 20

    var mValues = arrayOfNulls<ListNode<Value>?>(capacity + 1)

    fun put(key: Key?, value: Value?) {
        if (key != null) {
            val hash = key.hashCode()
            val position = hash % capacity + 1
            putForPosition(position, value)
        } else {
            putForPosition(0, value)
        }
    }

    private fun putForPosition(position: Int, value: Value?) {
        if (mValues.getOrNull(position) != null) {
            var list = mValues.getOrNull(position)
            while (list?.next != null) {
                list = list.next
            }
            list?.next = ListNode(value)
        } else {
            mValues.set(position, ListNode(value))
        }
    }

    fun get(key: Key?): Value? {
        if (key != null) {
            val hash = key.hashCode()
            val position = hash % capacity + 1
            return mValues.getOrNull(position)?.data
        } else {
            return mValues.getOrNull(0)?.data
        }
    }

    fun values(): List<Value> =
        mValues.mapNotNull { it?.data }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val map = MyHashMap<Int,Int>()
            map.put(23, 78)
            map.put(67, 99)
            println(map.values())
            println(map.get(23))
            println(map.get(67))
            println(map.get(45))
        }
    }
}