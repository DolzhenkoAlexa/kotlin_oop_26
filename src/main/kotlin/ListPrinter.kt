package org.example

import org.example.list.CustomArrayList
import org.example.list.CustomList

class ListPrinter {
    fun printList(collection: CustomList) {
        print("Printing:")
        print("[")
        for (i in 0 until collection.size) {
            if (i > 0) {
                print(", ")
            }
            print(collection[i])
        }
        println("]")
    }
}
