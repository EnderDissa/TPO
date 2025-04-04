package third_task

import third_task.utils.*

fun main() {
    val arthur = Person(
        name = "Артур",
        currentBeverage = Beverage(BeverageType.BEER)
    ).apply {
        actions.add(Action.HICCUP)
        actions.add(Action.CHOKE)
        actions.add(Action.JUMP)
    }

    val ford = Person(
        name = "Форд"
    ).apply {
        actions.add(Action.OFFER_WHISKEY)
    }

    val scene = Scene(
        description = "Барная сцена: разговоры, музыка автомата и глухой рокот снаружи",
        persons = listOf(arthur, ford),
        musicAutomat = MusicAutomat(song = "Classic Rock", volume = 70),
        soundEvent = SoundEvent(description = "Глухой рокот снаружи", volume = 80)
    )

    println(scene)
}
