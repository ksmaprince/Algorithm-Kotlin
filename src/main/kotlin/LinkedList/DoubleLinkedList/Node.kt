package LinkedList.DoubleLinkedList

data class Node<T : Any>(
    var prev: Node<T>? = null,
    var data: T? = null,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "${data} -> ${next.toString()}"
        } else {
            "${data}"
        }
    }
}
