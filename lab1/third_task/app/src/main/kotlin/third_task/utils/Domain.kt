package third_task.utils

enum class BeverageType {
    BEER, WHISKEY
}

data class Beverage(
    val type: BeverageType,
    val volumeMl: Int = 500
)

enum class Action {
    HICCUP, CHOKE, JUMP, CONVERSE, OFFER_WHISKEY
}

data class Person(
    val name: String,
    var currentBeverage: Beverage? = null,
    val actions: MutableList<Action> = mutableListOf()
)

data class MusicAutomat(
    val song: String,
    val volume: Int
)

data class SoundEvent(
    val description: String,
    val volume: Int
)

data class Scene(
    val description: String,
    val persons: List<Person>,
    val musicAutomat: MusicAutomat? = null,
    val soundEvent: SoundEvent? = null
)
