package LinkedList.DoubleLinkedList

class DoubleLinkedList<T : Any> {
    var head: Node<T>? = null

    private fun isEmpty(): Boolean = head == null

    fun length(): Int {
        var len = 0
        var current = head
        while (current != null) {
            len++
            current = current.next
        }
        return len
    }

    fun addFirst(data: T) {
        val newNode = Node(data = data)
        newNode.next = head
        head = newNode
    }

    fun addLast(data: T) {
        if (isEmpty()) {
            addFirst(data)
            return
        }
        val newNode = Node(data = data)
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = newNode
        newNode.prev = current
    }

    fun addAt(data: T, index: Int) {
        if (index < 0) throw IndexOutOfBoundsException("Index can't be negative")
        if (index == 0) {
            addFirst(data)
            return
        }
        val newNode = Node(data = data)
        var current = head
        for (i in 0..index - 2) {
            current = current?.next
        }
        newNode.next = current?.next
        current?.next?.prev = newNode
        newNode.prev = current
        current?.next = newNode
    }

    fun deleteFirst() {
        if (isEmpty()) throw IllegalStateException("Empty list")
        head = head?.next;
    }

    fun deleteLast() {
        if (isEmpty()) throw IllegalStateException("Empty list")
        var current = head
        while (current?.next != null){
            current = current?.next
        }
        current?.prev?.next = null
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }
}

fun main() {
    val lists = DoubleLinkedList<Int>()
    println(lists)

    lists.addFirst(1)
    lists.addFirst(0)
    println(lists)

    lists.addLast(2)
    lists.addLast(3)
    println(lists)

    lists.addAt(4, 3)
    println(lists)

    lists.deleteFirst()
    println(lists)
}