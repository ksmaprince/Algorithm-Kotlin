package LinkedList.SinglyLinkedList

import LinkedList.MySinglyLinkedListImpl

open class SinglyLinkedList<T : Any>  : Iterable<T>{

    private var head: Node<T>? = null

    private var size: Int = 0



    private fun isEmpty() = head == null

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
        current?.next = newNode
        size++
    }

    fun deleteFirst() {
        if (isEmpty()) throw IllegalStateException("List is Empty")
        head = head?.next
        size--
    }

    fun deleteLast() {
        if (isEmpty()) throw IllegalStateException("List is Empty")

        if (head?.next == null) {
            head = null
            size--
            return
        }
        var current = head
        while (current?.next?.next != null) {
            current = current.next
        }
        current?.next = null
        size--
    }

    fun deleteAt(index: Int) {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException("Index out of bound")
        if (index == 0) {
            deleteFirst()
            return
        }
        var current = head
        for (i in 0..index - 2) {
            current = current?.next
        }
        current?.next = current?.next?.next
        size--
    }

    fun getAt(index: Int): Node<T>? {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException("Index out of bound")

        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        return current
    }

    override fun iterator(): Iterator<T> {
        return MySinglyLinkedListImpl(this)
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

    println("Size: ${list.size()}")
    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    println(list.toString())
    println("Size: ${list.size()}")

    list.addFirst(0)
    println(list.toString())

    list.addAt(5, 2)
    println(list.toString())

    println("Get At index(2): ${list.getAt(2)?.data}")

    list.deleteFirst()
    println(list.toString())

    list.deleteLast()
    println(list.toString())

    list.deleteAt(1)
    println(list.toString())


    println("Size: ${list.size()}")

}