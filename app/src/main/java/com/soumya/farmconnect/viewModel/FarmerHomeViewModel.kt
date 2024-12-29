package com.soumya.farmconnect.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.soumya.farmconnect.R
import com.soumya.farmconnect.model.GridItem

class FarmerHomeViewModel: ViewModel() {
    var gridItems = mutableStateListOf<GridItem>()
        private set

    init {
        // Populate the grid with data
        loadGridItems()
    }

    private fun loadGridItems() {
        gridItems.addAll(
            listOf(
                GridItem(1,"Farm", R.drawable.farm),
                GridItem(2,"History", R.drawable.history),
                GridItem(3,"Inventory", R.drawable.inventory),
                GridItem(4,"Crops", R.drawable.crops)
            )
        )
    }
}