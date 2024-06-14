package fr.hamtec.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.basicstatecodelab.ui.theme.MonTheme

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember{ mutableStateOf(0) }
        Text(
            text = "You've had ${count} glasses.",
            modifier = modifier.padding(16.dp)
        )
        Button(
            onClick = { count++ },
            Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}

@Preview(showBackground = true, name = "Delirium")
@Composable
private fun WaterCounter() {
    MonTheme(darkTheme = false, dynamicColor = false) {
        WaterCounter(Modifier.padding(1.dp))
    }
}