package org.example

class SingleLinkedList : CustomList {

    private var firstNode: Node? = null
    override var size: Int = 0
        private set

    private class Node(
        var value: Int,
        var nextNode: Node? = null
    )

    override fun add(element: Int) {
        if (firstNode == null) {
            firstNode = Node(element)
        } else {
            var currentNode = firstNode
            while (currentNode?.nextNode != null) {
                currentNode = currentNode.nextNode
            }
            currentNode?.nextNode = Node(element)
        }
        size++
    }

    override fun set(index: Int, value: Int) {
        checkIndex(index)
        var currentNode = firstNode
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.nextNode
            currentIndex++
        }
        currentNode?.let { it.value = value }
    }

    override fun addFirst(element: Int) {
        val newNode = Node(element)
        newNode.nextNode = firstNode
        firstNode = newNode
        size++
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        var currentNode = firstNode
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.nextNode
            currentIndex++
        }
        return currentNode?.value ?: throw IndexOutOfBoundsException()
    }

    override fun indexOf(element: Int): Int {
        var currentNode = firstNode
        var currentPosition = 0
        while (currentNode != null) {
            if (currentNode.value == element) {
                return currentPosition
            }
            currentNode = currentNode.nextNode
            currentPosition++
        }
        return -1
    }

    override fun remove(element: Int): Boolean {
        if (firstNode == null) return false

        if (firstNode?.value == element) {
            firstNode = firstNode?.nextNode
            size--
            return true
        }
        
        var currentNode = firstNode
        while (currentNode?.nextNode != null) {
            if (currentNode.nextNode?.value == element) {
                currentNode.nextNode = currentNode.nextNode?.nextNode
                size--
                return true
            }
            currentNode = currentNode.nextNode
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var currentNode = firstNode

            override fun hasNext(): Boolean {
                return currentNode != null
            }

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                val value = currentNode?.value ?: throw NoSuchElementException()
                currentNode = currentNode?.nextNode
                return value
            }
        }
    }
    
    // Для проверки ошибок
    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }
    }
    
    // Для тестов
    override fun contains(element: Int): Boolean {
        var currentNode = firstNode
        while (currentNode != null) {
            if (currentNode.value == element) {
                return true
            }
            currentNode = currentNode.nextNode
        }
        return false
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also { it.add(item) }
            }
    }
}
