package third_task.utils.commands

class JumpUpCommand(private val person: Person) : UndoableCommand {
    override fun execute() {
        println("${person.name} jumps to feet")
    }

    override fun undo() {
        println("${person.name} sits back down")
    }
}