package com.soumya.farmconnect.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.soumya.farmconnect.R
import com.soumya.farmconnect.ui.components.BaseBackground
import com.soumya.farmconnect.viewModel.ForgotPasswordViewModel

@Composable
fun ForgotPassword(
    navController: NavHostController,
    viewModel: ForgotPasswordViewModel = viewModel()
) {
    val email by viewModel.email.collectAsState()
    val message by viewModel.message.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Forgot Password?",
                    fontSize = 20.sp,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    ),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Enter your registered email to receive a password reset link.",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(horizontal = 32.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Email icon",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .padding(end = 8.dp)
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = viewModel::onEmailChange,
                        label = { Text("Email Address", color=Color.Black) },
                        modifier = Modifier.weight(1f),
                        isError = email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(
                            email
                        ).matches(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Done
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF5F5DC),
                            unfocusedContainerColor = Color(0xFFF5F5DC),
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black,
                            cursorColor = Color.Black
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                                        .matches() && !isLoading
                                ) {
                                    viewModel.sendResetLink()
                                }
                            }
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (message.isNotEmpty()) {
                    Text(
                        text = message,
                        color = if (message.startsWith("Password")) Color.Black else Color.Red,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Button(
                    onClick = viewModel::sendResetLink,
                    enabled = android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches() && !isLoading,
                    modifier = Modifier
                        .padding(16.dp)
                        .width(180.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC)),

                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = Color.Black
                        )
                    } else {
                        Text(
                            text = "Send Reset Link",
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                TextButton(
                    onClick = {
                        viewModel.resetMessage()
                        navController.navigate("login/buy")
                    },
                    colors=ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5DC))
                ) {
                    Text(
                        text = "Back to Login",
                        color = Color.Black
                    )
                }
            }
        }
    }
}

