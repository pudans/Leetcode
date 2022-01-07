import easy.Easy706

open class CustomHashMap<Key : Any, Value : Any> {

    class Node<Key, Value>(val key: Key?, val data: Value?, var next: Node<Key, Value>?)

    val capacity = 19997
    val mult = 12582917

    private var data = arrayOfNulls<Node<Key, Value>?>(capacity + 1)

    open fun put(key: Key?, value: Value?) {
        remove(key)
        val position = getPosition(key)
        val node = Node(key, value, data[position])
        data[position] = node
    }

    open fun get(key: Key?): Value? {
        val position = getPosition(key)
        var node = data[position]
        while (node != null) {
            if (node.key == key) return node.data
            node = node.next
        }
        return null
    }

    open fun remove(key: Key?) {
        val position = getPosition(key)
        var node: Node<Key, Value>? = data[position] ?: return
        if (node?.key == key) {
            data[position] = node?.next
        } else {
            while (node?.next != null) {
                if (node.next?.key === key) {
                    node.next = node.next!!.next
                    return
                }
                node = node.next
            }
        }
    }

    private fun getPosition(key: Key?): Int = (key.hashCode().toLong() * mult % capacity).toInt()
}

fun main() {
    val map = CustomHashMap<Int, Int>()
    map.put(23, 78)
    map.put(67, 99)
    map.put(55, 78)
    map.put(66, 99)
    map.put(77, 78)
    map.put(88, 99)
    map.put(79, 78)
    map.put(89, 99)
    println(map.get(23))
    println(map.get(67))
    println(map.get(45))
    println(map.get(89))
}