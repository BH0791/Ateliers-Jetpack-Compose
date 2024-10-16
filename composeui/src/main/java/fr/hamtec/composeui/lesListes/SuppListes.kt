package fr.hamtec.composeui.lesListes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme

data class Person(val name: String, val age: Int)

@Composable
fun FirstLazyColumn() {
    val people = listOf(
        Person("John Doe", 25),
        Person("Jane Smith", 30),
        Person("Alice Johnson", 20),
        Person("Bob Williams", 27)
    )
    val people2 = mutableListOf(
        Person("John", 44),
        Person("Jane", 20),
        Person("Alice", 74),
        Person("Bob", 15)
    )
    people2.add(Person("Toto", 55))

    PersonList(people2)
}

@Composable
fun PersonList(people: List<Person>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()) {
        item {
            Text(
                text = "Mise en page",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF458562),
                fontStyle = FontStyle.Italic
            )
        }
        items(people.size) {index ->
            val person = people[index]
            Text(text = "Name: ${person.name}, age: ${person.age} ans")
        }
    }
}
@Composable
fun NumbersList() {
    LazyColumn {
        items(10) { index ->
            Text(
                text = "Item $index",
                modifier = Modifier.clickable {
                    println("Item $index clicked")
                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PersonListPreview(){
    AteliersJetpackComposeTheme {
        FirstLazyColumn()
    }
}
@Preview(showBackground = true)
@Composable
fun NumbersListPreview(){
    AteliersJetpackComposeTheme {
        NumbersList()
    }
}