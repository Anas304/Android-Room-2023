package com.example.roomdb.ui.screens.entery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdb.data.repository.ItemRepository
import com.example.roomdb.data.room.Item

class ItemEntryViewModel(val itemRepository: ItemRepository) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set


    fun updateUiState(itemDetails: ItemDetails = ItemDetails()) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))

    }

   suspend fun saveItem() {
        if (validateInput()) {
            itemRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            title.isNotBlank()
        }

    }


    /**
     * Represents Ui State for an Item.
     */
    data class ItemUiState(
        val itemDetails: ItemDetails = ItemDetails(),
        val isEntryValid: Boolean = false
    )

    data class ItemDetails(val id: Int = 0, val title: String = "")
}

private fun ItemEntryViewModel.ItemDetails.toItem(): Item = Item(id = id, title = title)