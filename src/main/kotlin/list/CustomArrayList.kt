package org.example.list
import org.example.CustomList

class CustomArrayList(startSize: Int = 10) : CustomList {
    private var inner = IntArray(startSize)
    override var size = 0
        private set

    override fun get(index: Int): Int {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException("Error: index < 0 or index >= size")
        return inner[index]
    }

    override fun set(index: Int, value: Int) {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException("Error: index < 0 or index >= size")
        inner[index] = value
    }

    private fun resize(newSize: Int) {
        inner = inner.copyOf(newSize)
    }

    override fun add(element: Int) {
        if (size == inner.size) {
            resize(inner.size * 2)
        }
        inner[size] = element
        size++
    }

    override fun addFirst(element: Int) {
        if (size == inner.size) {
            resize(inner.size * 2)
        }
        for (i in size downTo 1) {
            inner[i] = inner[i - 1]
        }
        inner[0] = element
        size++
    }

    override fun remove(element: Int): Boolean {
        val index = indexOf(element)
        if (index == -1) {
            return false
        }

        for (i in index until size - 1) {
            inner[i] = inner[i + 1]
        }
        size--
        return true
    }

    override fun indexOf(element: Int): Int {
        for (i in 0 until size) {
            if (inner[i] == element) {
                return i
            }
        }
        return -1
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var currentIndex = 0
            override fun hasNext(): Boolean = currentIndex < size
            override fun next(): Int = get(currentIndex++)
        }
    }

    // Для тестов
    override fun contains(element: Int): Boolean {
        return indexOf(element) != -1
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            CustomArrayList(items.size).apply {
                items.forEach { add(it) }
            }
    }
}
