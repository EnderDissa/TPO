package third_task.utils.commands

import third_task.utils.*


class JumpUpCommand(private val person: Person) : UndoableCommand {
    override fun execute() {
        println("${person.name} jumps to feet")
        person.setState("in air")
    }

    override fun undo() {
        println("${person.name} sits back down")
        person.setState("on ground")
    }
}