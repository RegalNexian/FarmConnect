package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.soumya.farmconnect.R
import com.soumya.farmconnect.ui.components.BaseBackground


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FarmerHome(navController: NavHostController) {
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
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NavigationGridWithDescriptions(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationGridWithDescriptions(navController: NavHostController) {
    val navigationItems = listOf(
        NavigationItem("Farm", R.drawable.farm, " ", "Screens.Farm"),
        NavigationItem("History", R.drawable.history, " ", "Screens.History"),
        NavigationItem("Inventory", R.drawable.inventory, " ", "Screens.Inventory"),
        NavigationItem("Crop", R.drawable.crops, " ", "Screens.Crop")
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(navigationItems.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowItems.forEach { item ->
                    NavigationButton(
                        item = item,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationButton(
    item: NavigationItem,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .padding(horizontal = 8.dp)
            .clickable { navController.navigate(item.route) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Image(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentScale = ContentScale.Fit
            )
        }
        Text(
            text = item.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = item.description,
            fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp),
            textAlign = TextAlign.Center
        )
    }
}

data class NavigationItem(
    val name: String,
    val iconRes: Int,
    val description: String,
    val route: String
)