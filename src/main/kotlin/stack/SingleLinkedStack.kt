package org.example.stack

import org.example.list.SingleLinkedList
// import org.example.Stack

class SingleLinkedStack : SingleLinkedList(), Stack {

    override fun push(value: Int) {
        addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Error: Stack is empty")
        }
        val value = get(0)
        remove(value)
        return value
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Error: Stack is empty")
        }
        return get(0)
    }

    override val isEmpty: Boolean
        get() = size == 0
}
