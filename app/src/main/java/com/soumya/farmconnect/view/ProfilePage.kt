package com.soumya.farmconnect.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BuyerProfile(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE7FFE7)) // Light green background
    ) {
        // Header Section
        BuyerHeaderSection()

        // Details Section
        BuyerDetailsSection()

        // Promotional Section
        BuyerPromotionalSection()

        // Bottom Navigation
        BuyerBottomNavigationBar(navController)
    }
}

@Composable
fun BuyerHeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Profile Icon and Buyer Info
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                shape = CircleShape,
                color = Color.Gray,
                modifier = Modifier.size(50.dp)
            ) {
                // Profile Icon Placeholder
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "BUYER #1", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Button(
                    onClick = { /* Edit profile logic */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Green color
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier = Modifier.height(30.dp)
                ) {
                    Text(text = "EDIT PROFILE", fontSize = 12.sp, color = Color.White)
                }
            }
        }

        // Notification Icon
        Icon(
            painter = painterResource(id = android.R.drawable.ic_dialog_info),
            contentDescription = "Notification Icon",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun BuyerDetailsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Personal Information
        SectionHeader(title = "PERSONAL INFORMATION")
        Text(text = "E-MAIL: john.doe@example.com")
        Text(text = "PHONE: +123 456 7890")
        Text(text = "ADDRESS: _XXX_XX")

        Spacer(modifier = Modifier.height(16.dp))

        // Purchase History
        SectionHeader(title = "PURCHASE HISTORY")
        Text(text = "ORDER #A2346")
        Text(text = "ORDER #A2347")
        Button(
            onClick = { /* View All Purchases */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "VIEW ALL", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Payment Details
        SectionHeader(title = "PAYMENT DETAILS")
        Text(text = "ORDER ID #5647: $120")
        Button(
            onClick = { /* View All Payments */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "VIEW ALL", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Settings */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text(text = "SETTINGS")
            }

            Button(
                onClick = { /* Seller Address */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(text = "SELLER ADDRESS")
            }

        }
    }
}

@Composable
fun BuyerPromotionalSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Seamless Buying Experience")
    }
}

@Composable
fun BuyerBottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /* Navigate to Home */ }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_menu_view), contentDescription = "Home")
        }
        IconButton(onClick = { /* Navigate to Orders */ }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_menu_recent_history), contentDescription = "Orders")
        }
        IconButton(onClick = { /* Navigate to Chatbot */ }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_btn_speak_now), contentDescription = "Chatbot")
        }
        IconButton(onClick = { /* Navigate to Profile */ }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_menu_myplaces), contentDescription = "Profile")
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}
