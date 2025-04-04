package third_task

import third_task.utils.commands.*
import third_task.utils.objects.*
import third_task.utils.*

fun main() {
    val arthur = Person("Arthur")
    val ford = Person("Ford")
    val drunk = Person("Drunk Guy")
    val beer = Drink("beer")
    val whiskey = Drink("whiskey")
    val music = Sound("ROCK")
    val jukebox = Jukebox(music)
    val conversation = Conversation(listOf(arthur, ford, drunk))
    val bar = Bar(listOf(arthur, ford, drunk), jukebox, listOf(conversation))

    bar.runBackgroundEvents()

    drunk.performAction(HiccupCommand(drunk))
    ford.performAction(OfferDrinkCommand(ford, drunk, whiskey))

    val sound = Sound("dull roar")
    sound.reach(listOf(arthur, ford))

    arthur.performAction(ChokeCommand(arthur, beer))
    arthur.performAction(JumpUpCommand(arthur))

    // Undo example
    println("\n-- Undoing last action --")
    arthur.undoLastAction() // Arthur sits back down
}