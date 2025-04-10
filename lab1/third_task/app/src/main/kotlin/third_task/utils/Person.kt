package third_task.utils

import third_task.utils.commands.*

class Person(val name: String) {
    private val actionHistory = mutableListOf<UndoableCommand>()

    fun performAction(command: Command) {
        command.execute()
        if (command is UndoableCommand) {
            actionHistory.add(command)
        }
    }

    fun undoLastAction() {
        if (actionHistory.isNotEmpty()) {
            actionHistory.removeLast().undo()
        }
    }

    fun getActionHistory()  = actionHistory
}