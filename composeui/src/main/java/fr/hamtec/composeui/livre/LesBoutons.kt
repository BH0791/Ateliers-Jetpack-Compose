package fr.hamtec.composeui.livre

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleBouton(): Unit {
    Button(
        onClick = {/* TODO */ },
        content = { Text(text = "Button") }
    )
}

@Composable
fun DifBouton(): Unit {
    Button(
        onClick = {/* TODO */ },
        shape = MaterialTheme.shapes.small,
        content = {
            Icon(
                Icons.Default.ConnectedTv,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Lecture en cours - 90%",
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "TV salon",
                    style = MaterialTheme.typography.bodySmall,
                )

            }
            Icon(
                Icons.Default.ChevronRight,
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp),
            )
        }
    )
}

@Composable
fun DifBouton2(): Unit {
    Button(
        modifier = Modifier.height(80.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = {/* TODO */ }
    ) {
        Column {
            Icon(
                Icons.Default.ConnectedTv,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
            )
            Text(
                text = "Lecture en cours - 90%",
                textAlign = TextAlign.Center,
            )
            Text(
                text = "TV salon",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Composable
fun DifBouton3(): Unit {
    Button(
        modifier = Modifier.height(80.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = {/* TODO */ },
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 6.dp),
        contentPadding = PaddingValues(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor  = MaterialTheme.colorScheme.secondary )
    ) {
        Column {
            Icon(
                Icons.Default.ConnectedTv,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
            )
            Text(
                text = "Lecture en cours - 90%",
                textAlign = TextAlign.Center,
            )
            Text(
                text = "TV salon",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

//----->Preview
@Preview(
    showBackground = true
)
@Composable
fun SimpleBoutonPreview() {
    SimpleBouton()
}

@Preview(showBackground = true)
@Composable
private fun DifBoutonPreview() {
    DifBouton()
}

@Preview(showBackground = true)
@Composable
private fun DifBouton2Preview() {
    Column {
        DifBouton2()
        DifBouton3()
    }
}

