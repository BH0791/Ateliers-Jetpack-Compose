package fr.hamtec.composeui.tpviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import fr.hamtec.composeui.data.dataSource

class MainViewModel : ViewModel(){
    private val listPersons = listOf("Alain", "Louis", "Jean", "Pierre")
    val randomPerson = listPersons.random()

    val uiState: MutableState<UiState> = mutableStateOf(UiState())

    init {
        onUiEvent(UiEvent.OnInit)
    }

    fun onUiEvent(uiEvent: UiEvent){
        when(uiEvent){
            is UiEvent.OnInit -> {
                uiState.value = UiState(
                    dataSource.randomPerson, 0
                )
            }
            is UiEvent.OnGenerateClick -> {
                uiState.value = UiState(
                    dataSource.randomPerson(), uiState.value.clickNumber + 1
                )
            }
        }
    }
}