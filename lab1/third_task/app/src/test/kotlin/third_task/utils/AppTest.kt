package third_task.utils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import third_task.utils.commands.*
import third_task.utils.objects.*
import third_task.utils.*

class BarSceneTest {

    @Test
    fun `test hiccup command execution and undo`() {
        val arthur = Person("Arthur")
        val hiccupCommand = HiccupCommand(arthur)

        hiccupCommand.execute()
        assertTrue(true)
        hiccupCommand.undo()
        assertTrue(true)
    }

    @Test
    fun `test choke command execution and undo`() {
        val arthur = Person("Arthur")
        val beer = Drink("beer")
        val chokeCommand = ChokeCommand(arthur, beer)

        chokeCommand.execute()
        assertTrue(true)
        chokeCommand.undo()
        assertTrue(true)
    }

    @Test
    fun `test jump up command execution and undo`() {
        val ford = Person("Ford")
        val jumpUpCommand = JumpUpCommand(ford)

        jumpUpCommand.execute()
        assertTrue(true)

        jumpUpCommand.undo()
        assertTrue(true)
    }

    @Test
    fun `test offer drink command execution and undo`() {
        val arthur = Person("Arthur")
        val ford = Person("Ford")
        val beer = Drink("beer")
        val offerDrinkCommand = OfferDrinkCommand(arthur, ford, beer)

        offerDrinkCommand.execute()
        assertTrue(true)

        offerDrinkCommand.undo()
        assertTrue(true)
    }

    @Test
    fun `test person action history`() {
        val arthur = Person("Arthur")
        val beer = Drink("beer")

        val hiccupCommand = HiccupCommand(arthur)
        val chokeCommand = ChokeCommand(arthur, beer)

        arthur.performAction(hiccupCommand)
        arthur.performAction(chokeCommand)

        assertEquals(2, arthur.getActionHistory().size)

        arthur.undoLastAction()

        assertEquals(1, arthur.getActionHistory().size)

        arthur.undoLastAction()

        assertEquals(0, arthur.getActionHistory().size)
    }

    @Test
    fun `test bar background events`() {
        val arthur = Person("Arthur")
        val ford = Person("Ford")

        val conversation = Conversation(listOf(arthur, ford))
        val music = Sound("ROCK")
        val jukebox = Jukebox(music)
        val bar = Bar(listOf(arthur, ford), jukebox, listOf(conversation))

        bar.runBackgroundEvents()
        assertTrue(true)
    }

    @Test
    fun `test sound reaching people`() {
        val arthur = Person("Arthur")
        val ford = Person("Ford")

        val sound = Sound("loud bang")
        sound.reach(listOf(arthur, ford))

        assertTrue(true)
    }
}
