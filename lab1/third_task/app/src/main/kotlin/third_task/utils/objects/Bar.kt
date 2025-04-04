package third_task.utils.objects

import third_task.utils.*

class Bar(
    val people: List<Person>,
    val jukebox: Jukebox,
    val conversations: List<Conversation>
) {
    fun runBackgroundEvents() {
        conversations.forEach { it.happen() }
        jukebox.playMusic(people)
    }
}