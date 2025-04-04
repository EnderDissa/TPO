package third_task.utils.objects

class Drink(val name: String) {
    val empty = false

    fun isEmpty() = empty

    fun drink() {
        empty = true
    } 
    override fun toString() = name
}