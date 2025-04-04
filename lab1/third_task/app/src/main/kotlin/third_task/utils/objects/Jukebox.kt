package third_task.utils.objects

import third_task.utils.*

class Jukebox(
    val sound: Sound
) {
    fun playMusic(people: List<Person>) {
        println("Music plays from the jukebox")
        sound.reach(people)
    }
}