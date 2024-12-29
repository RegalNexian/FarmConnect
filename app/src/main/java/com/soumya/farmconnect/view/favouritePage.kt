package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soumya.farmconnect.R
import com.soumya.farmconnect.ui.components.BaseBackground
import com.soumya.farmconnect.viewModel.favouritesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Favourites(viewModel: favouritesViewModel = viewModel()) {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp, start = 10.dp, end = 10.dp, bottom = 100.dp),
                containerColor = Color.Transparent
            ) { contentPadding ->

                Column(
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxSize()
                ) {
                    OutlinedTextField(
                        value = viewModel.searchText.value,
                        onValueChange = { viewModel.searchText.value = it },
                        label = { Text("Search") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF5F5DC),
                            unfocusedContainerColor = Color(0xFFF5F5DC),
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black,
                            cursorColor = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    FavList()
                }
            }
        }
    }
}

        @Composable
        fun FavList() {
            LazyColumn {
                items(15) {
                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .height(75.dp),
                        colors = CardDefaults.cardColors(Color(0xFFF5F5DC)),
                        elevation = CardDefaults.cardElevation()
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Image(
                                painter = painterResource(R.drawable.farmer),
                                contentDescription = "farmers image",
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .padding(10.dp)
                                    .height(50.dp),
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                text = "Farmers Name",
                                modifier = Modifier.padding(10.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favourite",
                                modifier = Modifier
                                    .padding(10.dp)
                            )
                        }

                    }
                }
            }
        }



