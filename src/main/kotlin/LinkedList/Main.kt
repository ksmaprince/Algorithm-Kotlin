package LinkedList

fun main(args: Array<String>) {
    val ll = LinkedList<String>()



    ll.push("A")
    ll.push("B")
    //ll.push("C")

    ll.append("D")
    ll.append("E")
    ll.append("F")

    ll.insertAt(2, "G")
    ll.insertAt(10, "PP")

    println(ll.toString())

    println("Pop: ${ll.pop()}")
    println(ll.toString())

   // println("DElete AT 1: ${ll.deleteAt(1)}")
    println("Delete Last: ${ll.deleteLast()}")
    println(ll.toString())
}