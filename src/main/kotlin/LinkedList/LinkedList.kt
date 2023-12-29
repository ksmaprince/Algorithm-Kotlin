package LinkedList

class LinkedList<T: Any> {

    private var head: Node<T>? = null
    private var size = 0

    private fun isEmpty() = size <= 0

    override fun toString(): String {
        return if (isEmpty()){
            "Empty List"
        }else{
            head.toString()
        }
    }

    fun push(data: T){ // Insert At First
        val node = Node(data, null)
        if (isEmpty()){
            head = node
        }else{
            node.next = head
            head = node
        }
        size++
    }

    fun append(data: T){  //Insert At Last
        if (isEmpty()){
            push(data)
        }else{
            val node = Node(data)
            var cur = head
            while (cur!!.next != null){
                cur = cur.next
            }
            cur.next = node
        }
        size++
    }

    fun insertAt( index: Int, data: T){
        if (isEmpty()) {
            push(data)
        }
        else if (index<=0){
            push(data)
        }else if(index>=size){
            append(data)
        }
        else{
            var cur = head
            var i = 1;
            while (i != index){
                cur = cur!!.next
                i++
            }
            val node = Node(data)
            node.next = cur!!.next
            cur.next = node
            size++
        }
    }

    fun pop(): T?{ //Delete Last
        return if (isEmpty()){
            null
        }else{
            val data = head!!.data
            head = head!!.next
            size--
            data
        }
    }

    fun deleteLast(): T?{
        return if (isEmpty()){
            null
        }else{
            var prev = head
            var cur = head!!.next
            while (cur!!.next!= null){
                cur = cur.next
                prev=prev!!.next
            }
            val data = cur.data
            prev!!.next = null
            size--
            data
        }
    }

    fun deleteAt(index: Int): T?{
        return if (isEmpty()){
            null
        }else{
            var cur = head
            var i = 0

            while (i != index){
                i++
                cur = cur!!.next
            }
            val data = cur!!.data
            if (cur.next != null) cur = cur!!.next!!.next
            else cur = null
            size--
            data
        }
    }

}


