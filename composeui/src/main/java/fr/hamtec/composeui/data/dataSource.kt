package fr.hamtec.composeui.data

object dataSource {
    private val listPersons = listOf("Alain", "Louis", "Jean", "Pierre")
    val randomPerson = listPersons.random()
    fun randomPerson() = listPersons.random()
}