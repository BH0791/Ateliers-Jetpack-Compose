package fr.hamtec.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import fr.hamtec.inventoryapp.data.Item
import fr.hamtec.inventoryapp.data.ItemsRepository
import java.text.NumberFormat

class ItemEntryViewModel(
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    private fun validateInput(
        uiState: ItemDetails = itemUiState.itemDetails
    ): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
    suspend fun saveItem() {
        itemsRepository.insertItem(itemUiState.itemDetails.toItem())
    }
}


data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

/**
 * La fonction d'extension ItemDetails.toItem() convertit l'objet d'état de l'UI ItemUiState en type d'entité Item.
 */
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

/**
 * La fonction d'extension ItemDetails.toItem() convertit l'objet d'état de l'UI ItemUiState en type d'entité Item.
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * La fonction d'extension Item.toItemDetails() convertit l'objet d'entité Room Item en ItemDetails.
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    price = price.toString(),
    quantity = quantity.toString()
)

fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}



