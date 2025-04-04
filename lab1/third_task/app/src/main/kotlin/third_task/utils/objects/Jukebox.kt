package third_task.utils.objects

class Jukebox(
    val sound: Sound
) {
    fun playMusic(people: List<Person>) {
        println("Music plays from the jukebox")
        sound.reach(people)
    }
}