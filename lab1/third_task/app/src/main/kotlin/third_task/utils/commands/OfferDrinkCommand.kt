package third_task.utils.commands

class OfferDrinkCommand(
    private val giver: Person,
    private val receiver: Person,
    private val drink: Drink
) : UndoableCommand {
    override fun execute() {
        println("${giver.name} offers ${receiver.name} some ${drink.name}")
    }

    override fun undo() {
        println("${giver.name} takes back the ${drink.name} from ${receiver.name}")
    }
}