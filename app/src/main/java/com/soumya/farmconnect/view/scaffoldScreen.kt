package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.soumya.farmconnect.R
import com.soumya.farmconnect.viewModel.HomeViewModel
import com.soumya.farmconnect.viewModel.ScaffoldViewModel
import com.soumya.farmconnect.view.SettingsPage


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldScreen(navController: NavHostController, viewModel: ScaffoldViewModel) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Topbar(navController = rememberNavController())
        },
        bottomBar = {
            BottomNavigation()
        }
    ) {
        ContentScreen()
    }
}

@Composable
fun ContentScreen(viewModel: ScaffoldViewModel = viewModel()) {
    when(viewModel.selectedIndex.intValue) {
        0 -> Home(navController = rememberNavController(), viewModel = HomeViewModel())
        1 -> Favourites()
        2 -> ShoppingCart()
        3 -> Message(navController = rememberNavController())
    }
}



@Composable
fun BottomNavigation(viewModel: ScaffoldViewModel = viewModel()) {
    NavigationBar (
        containerColor = Color(0xFFF5F5DC)
    ){
        viewModel.navItemList.forEachIndexed { index, _ ->
            NavigationBarItem(
                selected = viewModel.selectedIndex.intValue == index,
                onClick = {
                    viewModel.selectedIndex.intValue = index
                },
                icon = { Icon(imageVector = viewModel.navItemList[index].icon,
                    contentDescription = viewModel.navItemList[index].label)
                },
                label = { Text(text = viewModel.navItemList[index].label) }
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(navController: NavHostController, viewModel: ScaffoldViewModel = viewModel()) {
    TopAppBar(
        navigationIcon = {
            Image(painterResource(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(90.dp)
                    .padding(5.dp),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF5F5DC)),

        title = {
            when(viewModel.selectedIndex.intValue) {
                0 -> Text("FarmConnect", color = Color.Black)
                1 -> Text("Favourites", color = Color.Black)
                2 -> Text("Shopping Cart", color = Color.Black)
                3 -> Text("Message", color = Color.Black)
            }
        },
        actions = {
            //Dropdown Menu
            IconButton(onClick = { viewModel.expanded.value = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options",
                    tint=Color.Black

                )
            }
            DropdownMenu(
                modifier = Modifier.width(150.dp),
                expanded = viewModel.expanded.value,
                onDismissRequest = { viewModel.expanded.value = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = {
                        navController.navigate("Screens.BuyerProfile")
                        viewModel.expanded.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Language") },
                    onClick = {
                        viewModel.expanded.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Setting") },
                    onClick = {
                        navController.navigate("Setting")
                        viewModel.expanded.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        navController.navigate("login/buy")
                        viewModel.expanded.value = false
                    }
                )
            }
        }
    )
}
