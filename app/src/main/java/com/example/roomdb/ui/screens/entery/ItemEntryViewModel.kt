package com.example.roomdb.ui.screens.entery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdb.data.repository.ItemRepository

class ItemEntryViewModel(val itemRepository: ItemRepository) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    /**
     * Represents Ui State for an Item.
     */
    data class ItemUiState(val itemDetails: ItemDetails = ItemDetails(), val isEntryValid: Boolean = false)

    data class ItemDetails(val id: Int = 0, val title: String = "")
}