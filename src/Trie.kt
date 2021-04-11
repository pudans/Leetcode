class Trie {

    class Node(val value: Char, var isEnd: Boolean = false) {
        val nodes: ArrayList<Node> = arrayListOf()

        override fun toString(): String {
            return "{ $value - $isEnd }, "
        }
    }

    private val map = HashMap<Char, Node>()

    fun insert(word: String) {
        if (word.isEmpty()) {
            return
        }
        var node: Node = map[word[0]] ?: Node(word[0], word.length == 1)
        map.put(word[0], node)

        for (i in 1 until word.length) {

            val newNodeIndex = node.nodes.indexOfFirst { it.value == word[i] }
            var newNode = node.nodes.getOrNull(newNodeIndex)
            if (newNodeIndex >= 0 && newNode != null) {
                if (i == word.length - 1) {
                    newNode.isEnd = true
                    node.nodes.set(newNodeIndex, newNode)
                }
            } else {
                newNode = Node(word[i], word.length - 1 == i)
                node.nodes.add(newNode)

            }
            node = newNode
        }
    }

    fun search(word: String): Boolean {
        var node = map[word[0]] ?: return false
        for (i in 1 until word.length) {
            node = node.nodes.find { it.value == word[i] } ?: return false
            if (i == word.length - 1) {
                return node.isEnd
            }
        }
        return node.isEnd
    }

    fun startsWith(word: String): Boolean {
        var node = map[word[0]] ?: return false
        for (i in 1 until word.length) {
            node = node.nodes.find { it.value == word[i] } ?: return false
        }
        return true
    }

    override fun toString(): String {

        val result = ArrayList<ArrayList<Node>>()

        fun traverse(root: Node, level: Int = 0) {
            val dd = result.getOrElse(level) { ArrayList(level * 2) }
            dd.add(root)
            if (result.size <= level) result.add(dd) else result[level] = dd

            root.nodes.forEach { traverse(it, level + 1) }
        }

        map.values.firstOrNull()?.let { traverse(it) }

        var builder = StringBuilder()
        result.forEachIndexed { index, arrayList ->
            builder.append(index).append(": ")
            builder.append(arrayList.joinToString { it.toString() })
            builder.append("\n")
        }

        return builder.toString()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val trie = Trie()

            trie.insert("that")
            trie.insert("this")
            trie.insert("thus")
            trie.insert("the")
            println(trie.toString())

            println("search this ${trie.search("this")}")
            println("search thas ${trie.search("thas")}")
            println("search these ${trie.search("these")}")
            println("search th ${trie.search("th")}")
            println("search the ${trie.search("the")}")

            println("startsWith th ${trie.startsWith("th")}")
            println("startsWith thi ${trie.startsWith("thi")}")
            println("startsWith thh ${trie.startsWith("thh")}")
        }
    }
}