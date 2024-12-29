package com.soumya.farmconnect.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.soumya.farmconnect.R
import com.soumya.farmconnect.viewModel.BuyLoginViewModel
import com.soumya.farmconnect.ui.components.BaseBackground
@Composable
fun Login(navController: NavHostController, viewModel: BuyLoginViewModel = viewModel(), usertype: String?) {
    val user = if (usertype == "buy") "Buyer" else "Seller"
    val showError = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }
    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize()
                ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

        Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome $user",
            fontSize = 20.sp,
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "login image",
            modifier = Modifier.size(200.dp),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Email icon",
                modifier = Modifier.size(40.dp)
                    .clip(
                    RoundedCornerShape(8.dp))
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = {
                    viewModel.email.value = it
                    showError.value = false
                },
                label = { Text("Email", color = Color.Black) },
                modifier = Modifier.weight(1f),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = showError.value,
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

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Password icon",
                modifier = Modifier.size(40.dp)
                    .clip(
                        RoundedCornerShape(8.dp))
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = {
                    viewModel.password.value = it
                    showError.value = false
                },
                label = { Text("Password", color = Color.Black) },
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.weight(1f),


                isError = showError.value,
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

        if (showError.value) {
            Text(
                text = errorMessage.value,
                color = Color.Red,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                onClick = { navController.navigate("forgot") },
            ) {
                Text(
                    text = "Forgot Password?",
                    color = Color.Black,
                )
            }
        }

        Button(
            onClick = {
                when {
                    viewModel.email.value.isEmpty() && viewModel.password.value.isEmpty() -> {
                        errorMessage.value = "Please enter email and password"
                        showError.value = true
                    }
                    viewModel.email.value.isEmpty() -> {
                        errorMessage.value = "Please enter email"
                        showError.value = true
                    }
                    viewModel.password.value.isEmpty() -> {
                        errorMessage.value = "Please enter password"
                        showError.value = true
                    }
                    else -> {
                        if (usertype == "buy") {
                            navController.navigate("scaffold")
                        } else {
                            navController.navigate("farmer scaffold")
                        }
                    }
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .width(180.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC))
        ) {
            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don't have an account?",
                color = Color.Black,
                modifier = Modifier.padding(2.dp),
            )
            Text(
                text = "Sign Up",
                color = Color(0xFFF5F5DC),
                modifier = Modifier
                    .padding(2.dp)
                    .clickable { navController.navigate("signup") }
            )
        }

        HorizontalDivider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.padding(20.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Handle Google login */ },
                modifier = Modifier
                    .padding(8.dp)
                    .width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC))
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google logo",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Login with Google",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Button(
                onClick = { /* Handle Facebook login */ },
                modifier = Modifier
                    .padding(8.dp)
                    .width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC))

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fb),
                        contentDescription = "Facebook logo",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Login with Facebook",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}}}
