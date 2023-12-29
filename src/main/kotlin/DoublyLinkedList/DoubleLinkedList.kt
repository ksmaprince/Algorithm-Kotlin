package DoublyLinkedList

class DoubleLinkedList<T: Any> {
    var head: NodeItem<T>? = null
    var size = 0


    fun isEmpty() = size<=0

    override fun toString(): String {
        return if (isEmpty()){
            "Empty List"
        }else{
            head.toString()
        }
    }
    fun addFirst(data: T){
        if (isEmpty()) {
            head = NodeItem(null, data, null)
        }else{
            val node = NodeItem(null, data, null)
            node.next = head!!
            head = node
            node.prev = head
        }
        size++
    }

    fun addLast(data: T){
        if (isEmpty()){
            head = NodeItem(null, data, null)
        }else{
            var cur = head
            while (cur!!.next != null){
                cur = cur.next
            }
            val node = NodeItem(null, data, null)
            cur.next = node
            node.prev = cur
        }
        size++
    }

    fun addAt(index:Int, data: T){
        if (index>=size) addLast(data)
        else if (index<=0) addFirst(data)
        else{
            var prep = head
            var succ = head!!.next
            val node = NodeItem(null, data, null)
            var i = 1
            while (i != index){
                prep = prep!!.next
                succ = succ!!.next
                i++
            }
            prep!!.next = node
            node.prev = prep
            node.next = succ
            succ!!.prev = node
            size++
        }
    }

    fun pop(): T?{ //Delete First
        return if (isEmpty()) null
        else{
            val data = head!!.data
            val cur = head
            head = cur!!.next
            size--
            data
        }
    }

    fun deleteLast(): T?{
        return if (isEmpty()) null
        else{
            var prep = head
            var succ = head!!.next
            while (succ!!.next!=null){
                prep = prep!!.next
                succ = succ.next
            }
            val data = succ.data
            prep!!.next = null
            size--
            data
        }
    }

    fun deleteAt(index: Int): T?{
        return if (isEmpty()|| index>=size || index<0) null
        else if (index == 0) pop()
        else if (index == size-1) deleteLast()
        else{
            var prep = head
            var succ = head!!.next
            var i = 0
            while (i != index){
                prep = prep!!.next
                succ = succ!!.next
                i++
            }
            val  data = prep!!.data

            prep.prev!!.next = succ
            succ!!.prev = prep.prev
            data
        }
    }
    fun getAt(index: Int): T?{
        return if (isEmpty() || index>=size || index<0) null
        else {
            var cur = head
            var i = 0
            while (index != i){
                cur = cur!!.next
                i++
            }
            cur!!.data
        }
    }
}