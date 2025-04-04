package third_task.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DomainModelTest {

    @Test
    @DisplayName("Test creating a Person with Beverage and Actions")
    fun testPersonCreation() {
        val beer = Beverage(BeverageType.BEER, volumeMl = 500)
        val person = Person(name = "Артур", currentBeverage = beer)
        person.actions.add(Action.HICCUP)
        person.actions.add(Action.CHOKE)
        person.actions.add(Action.JUMP)

        assertEquals("Артур", person.name)
        assertEquals(BeverageType.BEER, person.currentBeverage?.type)
        assertTrue(person.actions.contains(Action.HICCUP))
        assertTrue(person.actions.contains(Action.CHOKE))
        assertTrue(person.actions.contains(Action.JUMP))
    }

    @Test
    @DisplayName("Test offering whiskey action")
    fun testOfferWhiskey() {
        val ford = Person(name = "Форд")
        val offerAction = Action.OFFER_WHISKEY
        ford.actions.add(offerAction)
        assertTrue(ford.actions.contains(offerAction))
    }

    @Test
    @DisplayName("Test scene composition")
    fun testSceneComposition() {
        val arthur = Person(name = "Артур", currentBeverage = Beverage(BeverageType.BEER))
        arthur.actions.add(Action.HICCUP)
        arthur.actions.add(Action.CHOKE)
        arthur.actions.add(Action.JUMP)

        val ford = Person(name = "Форд")
        ford.actions.add(Action.OFFER_WHISKEY)

        val musicAutomat = MusicAutomat(song = "Classic Rock", volume = 70)

        val soundEvent = SoundEvent(description = "Глухой рокот снаружи", volume = 80)

        val sceneDescription = "Сцена в баре с разговорами, музыкой и экшеном"
        val scene = Scene(
            description = sceneDescription,
            persons = listOf(arthur, ford),
            musicAutomat = musicAutomat,
            soundEvent = soundEvent
        )

        assertEquals(sceneDescription, scene.description)
        assertEquals(2, scene.persons.size)
        assertEquals("Classic Rock", scene.musicAutomat?.song)
        assertEquals("Глухой рокот снаружи", scene.soundEvent?.description)
    }
}
