package LinkedList.DoubleLinkedList

class DoubleLinkedList<T : Any> {
    private var head: Node<T>? = null
    private var size: Int = 0;

    private fun isEmpty(): Boolean = head == null

    fun size(): Int = size

    fun addFirst(data: T) {
        val newNode = Node(data = data)
        newNode.next = head
        head = newNode
        size++
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
        size++
    }

    fun addAt(data: T, index: Int) {
        if (index < 0 || index > size) throw IndexOutOfBoundsException("Index out of bound")
        if (index == 0) {
            addFirst(data)
            return
        }
        if (index == size) {
            addLast(data)
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
        size++
    }

    fun deleteFirst() {
        if (isEmpty()) throw IllegalStateException("Empty list")
        head = head?.next;
        size--
    }

    fun deleteLast() {
        if (isEmpty()) throw IllegalStateException("Empty list")
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.prev?.next = null
        size--
    }

    fun deleteAt(index: Int) {
        if (index < 0 || index > size - 1) {
            throw IndexOutOfBoundsException("Index out of bound")
        }
        if (index == 0) {
            deleteFirst()
            return
        }
        if (index == size - 1) {
            deleteLast()
            return
        }
        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        current?.prev?.next = current?.next
        current?.next?.prev = current?.prev
        size--
    }

    fun getAt(index: Int): Node<T>? {
        if (index < 0 || index > size - 1) throw IndexOutOfBoundsException("Index out of bound")
        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        return current
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
    println("Size: ${lists.size()}")

    lists.addFirst(1)
    lists.addFirst(0)
    println(lists)
    println("Size: ${lists.size()}")

    lists.addLast(2)
    lists.addLast(3)
    println(lists)
    println("Size: ${lists.size()}")
    lists.addAt(4, 4)
    println(lists)

    lists.deleteFirst()
    println(lists)

    println("Size: ${lists.size()}")
}