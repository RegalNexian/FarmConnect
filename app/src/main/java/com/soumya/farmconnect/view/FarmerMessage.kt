package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.soumya.farmconnect.ui.components.BaseBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Message(navController: NavHostController) {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sample data for recent buyers
            data class BuyerChat(
                val name: String,
                val lastMessage: String,
                val time: String,
                val imageUrl: String
            )

            val recentBuyers = listOf(
                BuyerChat(
                    "John Smith",
                    "Can you do $250 for the item?",
                    "2 mins ago",
                    "https://placeholder.com/user1"
                ),
                BuyerChat(
                    "Sarah Wilson",
                    "Thanks, I'll consider your offer",
                    "15 mins ago",
                    "https://placeholder.com/user2"
                ),
                BuyerChat(
                    "Mike Johnson",
                    "Is this still available?",
                    "1 hour ago",
                    "https://placeholder.com/user3"
                )
            )

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp, start = 10.dp, end = 10.dp, bottom = 15.dp),
                containerColor = Color.Transparent
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(recentBuyers) { buyer ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=50.dp)
                                .clickable { /* Handle click */ },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF5F5DC) // Makes the card background transparent
                            ),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Circular avatar placeholder
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                                            shape = CircleShape
                                        )
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = buyer.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = buyer.lastMessage,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.Black,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = buyer.time,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}