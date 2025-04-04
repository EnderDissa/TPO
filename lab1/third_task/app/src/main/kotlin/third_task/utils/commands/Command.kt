package third_task.utils.commands

interface Command {
    fun execute()
}

interface UndoableCommand : Command {
    fun undo()
}