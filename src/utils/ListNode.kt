package utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {

        fun create(vararg nodes: ListNode): ListNode {
            val first = nodes.first()
            var node = first
            for (i in 1 until nodes.size) {
                node.next = nodes[i]
                node = nodes[i]
            }
            return first
        }
    }
}

fun ListNode?.toStringList(): String? {
    if (this == null) return null
    var str = ""
    var node: ListNode? = this
    while (node != null) {
        str = str.plus(if (str.isNotEmpty()) " -> " else "")
        str = str.plus("(${node.`val`})")
        node = node.next
    }
    return str
}

fun ListNode?.add(node: ListNode?): ListNode? {
    this?.next = node
    return node
}

