package fr.hamtec.composeui.lesListes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

data class Person(val name: String, val age: Int)

@Composable
fun FirstLazyColumn() {
    val people = listOf(
        Person("John Doe", 25),
        Person("Jane Smith", 30),
        Person("Alice Johnson", 20),
        Person("Bob Williams", 27)
    )

    PersonList(people)
}

@Composable
fun PersonList(people: List<Person>) {
    LazyColumn {
        items(people.size) {index ->
            val person = people[index]
            Text(text = "Name: ${person.name}, Age: ${person.age}")
        }
    }
}