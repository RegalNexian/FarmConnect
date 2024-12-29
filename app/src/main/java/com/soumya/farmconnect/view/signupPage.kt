package com.soumya.farmconnect.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.soumya.farmconnect.R
import com.soumya.farmconnect.ui.components.BaseBackground
import com.soumya.farmconnect.viewModel.signUpViewModel

@Composable
fun SignUp(navController: NavHostController, viewModel: signUpViewModel = viewModel()) {
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                item {
                    Text(
                        text = "Sign Up",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }

                item {
                    Text(
                        text = "Register with your valid credentials",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 5.dp)
                    )
                }

                item {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "login image",
                        modifier = Modifier.size(200.dp),
                        alignment = Alignment.CenterStart
                    )
                }

                item {
                    Form(navController, viewModel)
                }
            }
        }
    }
}
@Composable
fun Form(navController: NavHostController, viewModel: signUpViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Name Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = viewModel.name.value,
                onValueChange = { viewModel.name.value = it },
                label = { Text("Name",color = Color.Black) },
                modifier = Modifier.weight(1f),

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
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Email Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = viewModel.eemail.value,
                onValueChange = { viewModel.eemail.value = it },
                label = { Text("Email",color = Color.Black) },
                modifier = Modifier.weight(1f),

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
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Password Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = viewModel.newpassword.value,
                onValueChange = { viewModel.newpassword.value = it },
                label = { Text("New Password",color = Color.Black) },
                modifier = Modifier.weight(1f),

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
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Confirm Password Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = viewModel.confirmpassword.value,
                onValueChange = { viewModel.confirmpassword.value = it },
                label = { Text("Confirm Password",color = Color.Black)},
                modifier = Modifier.weight(1f),
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
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .clip(RectangleShape),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC))
        ) {
            Text(text = "Sign Up")
        }

        Row {
            Text(
                text = "Already have an account?",
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 10.dp)
            )
            Text(
                text = "Login",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF5F5DC),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 10.dp, start = 5.dp)
                    .clickable { navController.popBackStack() }
            )
        }
    }
}


@Preview
@Composable
fun SignUpPreview() {
    SignUp(navController = rememberNavController())
}