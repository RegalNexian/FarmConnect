package com.soumya.farmconnect.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soumya.farmconnect.R
import com.soumya.farmconnect.ui.components.BaseBackground

@Composable
fun LandingPage(navController: NavHostController) {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                // Set background color to #2E7D32
            ) {


                // Foreground Content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Header()

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "FARMCONNECT",
                        fontSize = 24.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "farmconnect",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(300.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Buttons in Column
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = { navController.navigate("login/sell") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .padding(horizontal = 8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC)) // Set button color to #F5F5DC
                        ) {
                            Text(
                                text = "Sell",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }

                        Button(
                            onClick = { navController.navigate("login/buy") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .padding(horizontal = 8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC)) // Set button color to #F5F5DC
                        ) {
                            Text(
                                text = "Buy",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Footer(navController)
                }
            }
        }
    }
}

@Composable
fun Header() {
    // Create a FontFamily with the custom font
    val farmerFontFamily = FontFamily(
        Font(R.font.opensans2) // Replace with your actual font file name
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp, max = 300.dp) // Set a flexible height range
    ) {
        // Overlay Text (without background image)
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Empowering Farmers",
                fontSize = 26.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = farmerFontFamily,  // Apply custom font
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Ensuring Fair Deals",
                fontSize = 26.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = farmerFontFamily,  // Apply custom font
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Cultivating Trust",
                fontSize = 26.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = farmerFontFamily,  // Apply custom font
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Composable
fun Footer(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "About Us",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 5.dp)
                .clickable { navController.navigate("about us") },
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Copyright @ 2024 FarmConnect\n" +
                    "Privacy Policy\n" +
                    "Terms of Service\n" +
                    "Career",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook logo",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Image(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "LinkedIn logo",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
