package third_task.utils

class Conversation(val participants: List<Person>) {
    fun happen() {
        println("Conversation happening between ${participants.joinToString { it.name }}")
    }
}