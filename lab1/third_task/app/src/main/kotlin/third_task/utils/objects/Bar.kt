package third_task.utils.objects

class Bar(
    val people: List<Person>,
    val jukebox: Jukebox,
    val conversations: List<Conversation>
) {
    fun runBackgroundEvents() {
        conversations.forEach { it.happen() }
        jukebox.playMusic()
    }
}