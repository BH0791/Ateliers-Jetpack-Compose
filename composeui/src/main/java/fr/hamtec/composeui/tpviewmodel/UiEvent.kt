package fr.hamtec.composeui.tpviewmodel

sealed class UiEvent {
    object OnInit: UiEvent()
    object OnGenerateClick: UiEvent()
}