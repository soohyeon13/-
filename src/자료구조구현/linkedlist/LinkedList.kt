package 자료구조구현.linkedlist

import java.util.*

class LinkedList {
    private var head: Node? = null
    private var tail: Node? = null
    private var size = 0

    internal class Node(val d: Any) {
        var data = d
        var next: Node? = null
        override fun toString(): String {
            return data.toString()
        }
    }

    fun addFirst(data : Any) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
        size++
        if (head!!.next == null) {
            tail = head
        }
    }
    fun addLast(data : Any) {

    }
}