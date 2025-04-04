package third_task.utils

class Sound(val description: String) {
    fun reach(people: List<Person>) {
        println("Sound '$description' reaches ${people.joinToString { it.name }}")
    }
}