package fr.hamtec.composeui.livre

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme

@Composable
fun SimpleBouton(): Unit {
    Button(
        onClick = {/* TODO */},
        content = {Text(text = "Button")}
    )
}
@Composable
fun DifBouton(): Unit {
    Button(
        onClick = {/* TODO */},
        content = {
            Icon(
                Icons.Default.ConnectedTv,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
            )
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = "Lecture en cours - 90%",
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "TV salon",
                    style = MaterialTheme.typography.bodySmall,
                )
                Icon(
                    Icons.Default.ChevronRight,
                    contentDescription = null,
                    modifier= Modifier.padding(start = 16.dp),
                )
            }
        }
    )
}
//----->Preview
@Preview(showBackground = true)
@Composable
fun SimpleBoutonPreview(){
    SimpleBouton()
}

@Preview(showBackground = true)
@Composable
private fun DifBoutonPreview() {
    AteliersJetpackComposeTheme {
        DifBouton()
    }
}

