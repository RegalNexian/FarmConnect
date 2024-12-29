package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.soumya.farmconnect.ui.components.BaseBackground



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun History(navController: NavHostController) {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "History", modifier = Modifier.padding(16.dp))

            // Sample data
            val cropListings = listOf(
                CropListing("Wheat", 200.0, 50, "Jan 2023 - Mar 2023"),
                CropListing("Rice", 150.0, 30, "Feb 2023 - Apr 2023"),
                CropListing("Corn", 180.0, 40, "Mar 2023 - May 2023"),
                CropListing("Barley", 220.0, 20, "Apr 2023 - Jun 2023"),
                CropListing("Soybean", 250.0, 25, "May 2023 - Jul 2023")
            )

            // Scrollable list of crop listings
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                items(cropListings) { crop ->
                    CropCard(crop)
                }
            }
        }
    }
}

@Composable
fun CropCard(crop: CropListing) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Crop: ${crop.cropName}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Price: \$${crop.price}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Users: ${crop.users}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Time Period: ${crop.timePeriod}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

data class CropListing(
    val cropName: String,
    val price: Double,
    val users: Int,
    val timePeriod: String
)