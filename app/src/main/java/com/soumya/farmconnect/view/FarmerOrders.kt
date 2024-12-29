package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soumya.farmconnect.ui.components.BaseBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FarmerOrders() {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TransparentOrderCardList()
        }
    }
}

@Composable
fun TransparentOrderCardList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=110.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Recent Buyers",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(buyerList) { buyer ->
                BuyerCard(
                    buyerName = buyer.name,
                    cropName = buyer.crop,
                    quantity = buyer.quantity,
                    orderDate = buyer.orderDate
                )
            }
        }
    }
}

@Composable
fun BuyerCard(buyerName: String, cropName: String, quantity: String, orderDate: String) {
    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(4.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5DC)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = buyerName,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Crop: $cropName",
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Quantity: $quantity",
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 2.dp)
            )
            Text(
                text = orderDate,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

// Sample Data
data class Buyer(val name: String, val crop: String, val quantity: String, val orderDate: String)

val buyerList = listOf(
    Buyer("John Doe", "Wheat", "200 kg", "Ordered 5 days ago"),
    Buyer("Jane Smith", "Rice", "300 kg", "Ordered 7 days ago"),
    Buyer("Michael Johnson", "Corn", "150 kg", "Ordered 10 days ago"),
    Buyer("Emily Davis", "Soybeans", "250 kg", "Ordered 12 days ago"),
    Buyer("Robert Brown", "Barley", "180 kg", "Ordered 15 days ago"),
    Buyer("Olivia Wilson", "Oats", "210 kg", "Ordered 18 days ago"),
    Buyer("Sophia Martinez", "Millet", "170 kg", "Ordered 20 days ago")
)
