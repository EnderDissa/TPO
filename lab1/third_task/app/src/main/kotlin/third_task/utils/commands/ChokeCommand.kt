package third_task.utils.commands

class ChokeCommand(private val person: Person, private val drink: Drink) : UndoableCommand {
    override fun execute() {
        println("${person.name} chokes on ${drink.name}")
    }

    override fun undo() {
        println("${person.name} recovers from choking on ${drink.name}")
    }
}