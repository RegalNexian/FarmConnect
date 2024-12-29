package com.soumya.farmconnect.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.soumya.farmconnect.view.AboutUs
import com.soumya.farmconnect.view.BuyerProfile
import com.soumya.farmconnect.view.Crop
import com.soumya.farmconnect.view.Farm
import com.soumya.farmconnect.view.FarmerScaffold
import com.soumya.farmconnect.view.Favourites
import com.soumya.farmconnect.view.ForgotPassword
import com.soumya.farmconnect.view.History
import com.soumya.farmconnect.view.Home
import com.soumya.farmconnect.view.Inventory
import com.soumya.farmconnect.view.LandingPage
import com.soumya.farmconnect.view.Login
import com.soumya.farmconnect.view.FarmerProfile
import com.soumya.farmconnect.view.ScaffoldScreen
import com.soumya.farmconnect.view.SignUp
import com.soumya.farmconnect.view.SettingsPage  // Import the SettingsPage composable


@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun Nav() {
    val navCtrl = rememberNavController()
    NavHost(navController = navCtrl, startDestination = Screens.Auth.route) {

        // Welcome Navigation
        navigation(startDestination = Screens.LandingPage.route, route = Screens.Auth.route) {

            composable(Screens.LandingPage.route) {
                LandingPage(navController = navCtrl)
            }

            composable(Screens.AboutUs.route) {
                AboutUs()
            }

            composable("login/{usertype}") { backStackEntry ->
                val usertype = backStackEntry.arguments?.getString("usertype") ?: "buy"
                Login(navController = navCtrl, usertype = usertype)
            }

            composable(Screens.SignUp.route) {
                SignUp(navController = navCtrl)
            }

            composable(Screens.ForgotPassword.route) {
                ForgotPassword(navController = navCtrl)
            }
        }

        ///////////////////////* Buyer's Screen*/////////////////////////////

        navigation(startDestination = Screens.Scaffold.route, route = Screens.Sell.route) {
            composable(Screens.Scaffold.route) {
                ScaffoldScreen(navController = navCtrl, viewModel = viewModel())
            }

            composable(Screens.Home.route) {
                Home(navController = navCtrl)
            }

            composable(Screens.Favourites.route) {
                Favourites()
            }

            composable(Screens.BuyProfile.route) {
                BuyerProfile(navController = navCtrl)
            }

            // Add SettingsPage route for Buyer's Screen
            composable(Screens.Settings.route) {
                SettingsPage(navController = navCtrl)
            }
        }

        ///////////////////* Farmer's Screen */////////////////////////////////
        navigation(startDestination = Screens.FarmerScaffold.route, route = Screens.Buy.route) {
            composable(Screens.FarmerScaffold.route) {
                FarmerScaffold(navController = navCtrl, viewModel = viewModel())
            }

            composable(Screens.Farm.route) {
                Farm(navController = navCtrl)
            }

            composable(Screens.Inventory.route) {
                Inventory(navController = navCtrl)
            }

            composable(Screens.History.route) {
                History(
                    navController = navCtrl
                )
            }

            composable(Screens.Crop.route) {
                Crop(navController = navCtrl)
            }

            composable(Screens.FarmerProfile.route) {
                FarmerProfile(navController = navCtrl)
            }

            // Add SettingsPage route for Farmer's Screen
            composable(Screens.Settings.route) {
                SettingsPage(navController = navCtrl)
            }
        }
    }
}
