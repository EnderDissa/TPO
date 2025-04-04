package second_task.utils

import kotlin.math.absoluteValue

class HashTable<V>(initialSize: Int = 28) {
    private var values: Array<Any?> = arrayOfNulls(initialSize)
    private var size: Int = 0
    private val deleted = Any()

    private fun hash(value: V): Int {
        return value.hashCode().absoluteValue % values.size
    }

    private fun rehash(oldHash: Int): Int {
        return (oldHash + 1) % values.size
    }

    operator fun plusAssign(value: V) {
        println(size)
        println(values.size)
        println(values.size * 0.75)
        if (size >= values.size.toDouble() * 0.75) {
            resize()
        }

        var hashValue = hash(value)
        var initialHash = hashValue

        while (true) {
            when (values[hashValue]) {
                null, deleted -> {
                    values[hashValue] = value
                    size++
                    return
                }
                else -> {
                    hashValue = rehash(hashValue)
                    if (hashValue == initialHash) {
                        resize()
                        hashValue = hash(value)
                        initialHash = hashValue
                    }
                }
            }
        }
    }

    operator fun get(value: V): V? {
        var hashValue = hash(value)
        var initialHash = hashValue

        while (true) {
            when (values[hashValue]) {
                null -> return null
                value -> return values[hashValue] as V
                else -> {
                    hashValue = rehash(hashValue)
                    if (hashValue == initialHash) return null
                }
            }
        }
    }

    fun remove(value: V) {
        var hashValue = hash(value)
        var initialHash = hashValue

        while (true) {
            when (values[hashValue]) {
                null -> return
                value -> {
                    values[hashValue] = deleted
                    size--
                    return
                }
                else -> {
                    hashValue = rehash(hashValue)
                    if (hashValue == initialHash) return
                }
            }
        }
    }

    operator fun contains(value: V): Boolean {
        return get(value) != null
    }

    fun count(): Int {
        return size
    }

    fun getSize(): Int = values.size

    fun loadFactor(): Double {
        return size.toDouble() / values.size
    }

    private fun resize() {
        val oldValues = values

        values = arrayOfNulls(oldValues.size * 2)
        size = 0

        for (element in oldValues) {
            if (element != null && element != deleted) {
                this.plusAssign(element as V)
            }
        }
    }

    override fun toString(): String {
        return values.filter { it != null && it != deleted }.joinToString()
    }
}