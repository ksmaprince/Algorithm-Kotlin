package LinkedList

fun main(args: Array<String>) {
    val ll = LinkedList<String>()

    ll.push("A")
    ll.push("B")
    ll.push("C")

    ll.append("D")
    ll.append("E")
//    ll.append("F")
//
    ll.insertAt(2, "G")
    ll.insertAt(10, "PP")
//
    println(ll.toString())
//
    println("Pop: ${ll.pop()}")
    println(ll.toString())

    println("DELETE AT 5: ${ll.deleteAt(5)}")
//    println("Delete Last: ${ll.deleteLast()}")
    println(ll.toString())
}