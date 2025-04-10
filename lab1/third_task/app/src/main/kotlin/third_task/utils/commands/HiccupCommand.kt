package third_task.utils.commands

import third_task.utils.*

class HiccupCommand(private val person: Person) : UndoableCommand {
    override fun execute() {
        println("${person.name} hiccups")
    }

    override fun undo() {
        println("${person.name} stops hiccuping")
    }
}