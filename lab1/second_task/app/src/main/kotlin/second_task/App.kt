package second_task

import second_task.utils.HashTable

fun main() {
    val table = HashTable<String>(4)

    table += "a"
    table += "b"
    table += "c"
    
    /*
    table += "apple"
    table += "banana"
    table += "orange"
    
    println("apple" in table) // true
    println("pear" in table)  // false
    
    table.remove("banana")
    println("banana" in table) // false
    
    println(table.count()) // 2
    println(table.loadFactor())
    
    println(table) // [apple, orange]
    */
}