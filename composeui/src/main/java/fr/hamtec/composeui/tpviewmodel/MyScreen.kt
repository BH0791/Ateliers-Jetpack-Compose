package fr.hamtec.composeui.tpviewmodel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun MyScreen(
    viewModel: MainViewModel = viewModel()
) {

val uiState = viewModel.uiState

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = uiState.value.currentName,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 25.sp
            )
            Button(
                onClick = {viewModel.onUiEvent(UiEvent.OnGenerateClick)}
            ) {
                Text(
                    text = "Générer (déjà ${uiState.value.clickNumber} foix)"
                )
            }
        }

    }
}
