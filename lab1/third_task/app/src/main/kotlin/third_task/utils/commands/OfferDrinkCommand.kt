package third_task.utils.commands

import third_task.utils.*
import third_task.utils.objects.*

class OfferDrinkCommand(
    private val giver: Person,
    private val receiver: Person,
    private val drink: Drink
) : UndoableCommand {
    override fun execute() {
        println("${giver.name} offers ${receiver.name} some ${drink.name}")
        person.setState("have drink in hand")
    }

    override fun undo() {
        println("${giver.name} takes back the ${drink.name} from ${receiver.name}")
        person.setState("brought drink from hand")
    }
}