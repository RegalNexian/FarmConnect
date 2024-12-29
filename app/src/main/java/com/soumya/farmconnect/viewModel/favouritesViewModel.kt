package com.soumya.farmconnect.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class favouritesViewModel: ViewModel() {

    val searchText = mutableStateOf("")
}