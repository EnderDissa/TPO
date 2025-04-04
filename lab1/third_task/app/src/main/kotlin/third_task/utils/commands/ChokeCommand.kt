package third_task.utils.commands

import third_task.utils.*
import third_task.utils.objects.*

class ChokeCommand(private val person: Person, private val drink: Drink) : UndoableCommand {
    override fun execute() {
        println("${person.name} chokes on ${drink.name}")
        person.setState("chokes")
    }

    override fun undo() {
        println("${person.name} recovers from choking on ${drink.name}")
        person.setState("recovers from choking")
    }
}