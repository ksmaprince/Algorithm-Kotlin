package LinkedList.SinglyLinkedList

class SinglyLinkedList<T : Any> {

    private var head: Node<T>? = null

    private fun isEmpty() = head == null

    fun length(): Int {
        var l = 0
        var current = head
        while (current != null) {
            l++
            current = current.next
        }
        return l
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
    }

    fun addAt(data: T, index: Int) {
        if (index < 0) throw IndexOutOfBoundsException("Index can't be negative")
        if (index == 0) {
            addFirst(data)
            return
        }
        val newNode = Node(data = data)
        if (isEmpty()) {
            head = newNode
        } else {
            var current = head
            for (i in 0..index - 2) {
                if (current == null || current.next == null) throw IndexOutOfBoundsException("Index out of bound")
                current = current.next
            }
            newNode.next = current?.next
            current?.next = newNode
        }
    }

    fun deleteFirst() {
        if (isEmpty()) throw IllegalStateException("List is Empty")
        head = head?.next
    }

    fun deleteLast() {
        if (isEmpty()) throw IllegalStateException("List is Empty")

        if (head?.next == null) {
            head = null
            return
        }
        var current = head
        while (current?.next?.next != null) {
            current = current.next
        }
        current?.next = null
    }

    fun deleteAt(index: Int) {
        if (index < 0) throw IndexOutOfBoundsException("Index can't be negative")
        if (index == 0) {
            deleteFirst()
            return
        }
        var current = head
        for (i in 0..index - 2) {
            if (current == null || current.next == null) throw IndexOutOfBoundsException("Index out of bound")
            current = current.next
        }
        current?.next = current?.next?.next
    }

    fun getAt(index: Int): T? {
        if (index < 0) throw IndexOutOfBoundsException("Index can't be negative")

        var current = head
        for (i in 0..index - 1) {
            if (current == null || current.next == null) throw IndexOutOfBoundsException("Index out of bound")
            current = current?.next
        }
        return current?.data
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
    val list = SinglyLinkedList<Int>()
    println(list.toString())

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    println(list.toString())
    println("Length/Size: ${list.length()}")

    list.addFirst(0)
    println(list.toString())

    list.addAt(5, 2)
    println(list.toString())

    println("Get At index(2): ${list.getAt(2)}")

    list.deleteFirst()
    println(list.toString())

    list.deleteLast()
    println(list.toString())

    list.deleteAt(1)
    println(list.toString())

}