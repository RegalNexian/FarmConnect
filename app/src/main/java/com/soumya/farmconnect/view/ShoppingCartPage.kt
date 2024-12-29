package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soumya.farmconnect.ui.components.BaseBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCart() {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp, start = 10.dp, end = 10.dp, bottom = 15.dp),
                containerColor = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Shopping Cart")
                }
            }
        }
    }
}


