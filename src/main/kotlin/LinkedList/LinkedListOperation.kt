package LinkedList

interface LinkedListOperation<T> {
    val size: Int
    fun isEmpty(): Boolean
    fun push(data: T)
    fun append(data: T)
    fun pop()
    fun removeLast()
    fun insertAt(data: T, index: Int)
    fun nodeAt(index: Int): T
    fun contains(element: T): Boolean
    fun containsAll(elements: Collection<T>): Boolean
}