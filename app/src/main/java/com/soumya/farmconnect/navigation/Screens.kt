package com.soumya.farmconnect.navigation

sealed class Screens(val route: String) {
    data object LandingPage : Screens(route = "landingPage")
    data object AboutUs : Screens(route = "about us")
    data object Login : Screens(route = "login")
    data object SignUp : Screens(route = "signup")
    data object  ForgotPassword : Screens(route = "forgot")

    data object Scaffold : Screens(route = "scaffold")
    data object Home : Screens(route = "home")
    data object Favourites : Screens(route = "favourites")
    data object Settings : Screens(route="settings")
    data object FarmerProfile : Screens(route = "profile1")
    data object BuyProfile :Screens(route = "profile2")

    data object FarmerScaffold : Screens(route = "farmer scaffold")
    data object Farm : Screens(route = "farm")
    data object Inventory : Screens(route = "inventory")
    data object History : Screens(route = "history")
    data object Crop : Screens(route = "crop")
    data object Auth : Screens(route = "auth")
    data object Sell : Screens(route = "sell")
    data object Buy : Screens(route = "buy")

}