package LinkedList

import LinkedList.SinglyLinkedList.Node
import LinkedList.SinglyLinkedList.SinglyLinkedList

class MySinglyLinkedListImpl<T:Any>(private val singlyLinkedList: SinglyLinkedList<T>) : LinkedListOperation<T>, Iterator<T>  {

    private var index = 0
    private var lastNode: Node<T>?= null

    override var size: Int = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    override fun push(data: T) {
        singlyLinkedList.addFirst(data)
    }

    override fun append(data: T) {
        singlyLinkedList.addLast(data)
    }

    override fun pop() {
        singlyLinkedList.deleteFirst()
    }

    override fun removeLast() {
        singlyLinkedList.deleteLast()
    }

    override fun nodeAt(index: Int) : T{
        return singlyLinkedList.getAt(index)?.data!!
    }

    override fun insertAt(data: T, index: Int) {
        singlyLinkedList.addAt(data, index)
    }

    override fun contains(element: T): Boolean {
        for (item in this){
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements){
            if (!contains(searched)) return false
        }
        return true
    }

    override fun hasNext(): Boolean {
        return index < singlyLinkedList.size()
    }

    override fun next(): T {
        if (index >= singlyLinkedList.size()) throw IndexOutOfBoundsException("Index out of bound")
        lastNode = if (index == 0){
            singlyLinkedList.getAt(0)
        }else{
            lastNode?.next
        }
        index++
        return lastNode!!.data!!
    }
}

fun main(){
    val list = MySinglyLinkedListImpl(SinglyLinkedList<Int>())
    list.push(1)
    list.push(2)
    list.push(3)
    for (item in list){
        println("Item ${item} in double : ${item * 2}")
    }

    println(list.contains(0))
}