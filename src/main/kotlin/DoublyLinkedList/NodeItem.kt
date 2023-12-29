package DoublyLinkedList

data class NodeItem<T: Any>(
    var prev: NodeItem<T>? = null,
    var data: T? = null,
    var next: NodeItem<T>? = null,
){
    override fun toString(): String {
        return if (next!= null){
            "$data -> ${next.toString()}"
        }else{
            "$data"
        }
    }
}
