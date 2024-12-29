package com.soumya.farmconnect.view


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.soumya.farmconnect.ui.components.BaseBackground

@Composable
fun SettingsPage(navController: NavHostController) {
    BaseBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),

        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SettingsOption(
                    title = "Enable Notifications",
                    description = "Toggle to enable or disable notifications.",
                    isChecked = remember { mutableStateOf(true) },
                    onCheckedChange = { /* Handle toggle state change */ }
                )

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                SettingsOption(
                    title = "Enable Dark Mode",
                    description = "Toggle to switch between light and dark mode.",
                    isChecked = remember { mutableStateOf(false) },
                    onCheckedChange = { /* Handle theme switch */ }
                )

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                SettingsOption(
                    title = "Clear Cache",
                    description = "Click to clear cached data.",
                    isChecked = remember { mutableStateOf(false) },
                    onCheckedChange = { /* Handle cache clearing action */ }
                )

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                SettingsOption(
                    title = "Log Out",
                    description = "Click to log out of the app.",
                    isChecked = remember { mutableStateOf(false) },
                    onCheckedChange = { /* Handle logout */ }
                )
            }
        }
    }
}

@Composable
fun SettingsOption(
    title: String,
    description: String,
    isChecked: MutableState<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 8.dp)
    ) {
        ListItem(
            modifier = Modifier.fillMaxSize(),
            headlineContent = { Text(text = title) },
            supportingContent = { Text(text = description) },
            trailingContent = {
                if (title == "Enable Notifications") {
                    Checkbox(
                        checked = isChecked.value,
                        onCheckedChange = { onCheckedChange(it) },
                        colors = CheckboxDefaults.colors(Color.Gray)
                    )
                } else if (title == "Enable Dark Mode") {
                    Switch(
                        checked = isChecked.value,
                        onCheckedChange = { onCheckedChange(it) },
                        colors = SwitchDefaults.colors(Color.Gray)
                    )
                } else {
                    // Other options, like Log Out or Clear Cache, can be buttons or custom actions
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { /* Handle action, e.g., log out or clear cache */ },

                    ) {
                        Text(
                            text = "Click to Perform Action",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        )
    }
}
