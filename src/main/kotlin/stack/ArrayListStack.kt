package org.example.stack

import org.example.list.CustomArrayList
// import org.example.Stack
import java.util.NoSuchElementException

class ArrayListStack : Stack {
    private val list = CustomArrayList()

    override fun push(value: Int) {
        list.addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Error: Stack is empty")
        }
        val value = list.get(0)
        list.remove(value)
        return value
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Error: Stack is empty")
        }
        return list.get(0)
    }

    override val isEmpty: Boolean
        get() = size == 0

    // Методы из CustomList (не получилось без них)
    override val size: Int get() = list.size
    override fun get(index: Int): Int = list.get(index)
    override fun set(index: Int, value: Int) = list.set(index, value)
    override fun add(element: Int) = list.add(element)
    override fun addFirst(element: Int) = list.addFirst(element)
    override fun remove(element: Int): Boolean = list.remove(element)
    override fun indexOf(element: Int): Int = list.indexOf(element)
    override fun iterator(): Iterator<Int> = list.iterator()
    override fun contains(element: Int): Boolean = list.contains(element)
}
