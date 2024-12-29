package com.soumya.farmconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.soumya.farmconnect.ui.components.BaseBackground
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import android.widget.CalendarView
import androidx.compose.ui.viewinterop.AndroidView
import java.text.SimpleDateFormat
import java.util.*

data class CropEntry(
    val cropName: String,
    val quantity: Float,
    val unit: String,
    val expectedHarvestDate: String,
    val soldQuantity: Float = 0f
)

@Composable
fun CustomDatePickerDialog(
    onDateSelected: (Calendar) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AndroidView(
                    { CalendarView(it) },
                    modifier = Modifier.wrapContentWidth(),
                    update = { views ->
                        views.setOnDateChangeListener { _, year, month, day ->
                            val calendar = Calendar.getInstance().apply {
                                set(year, month, day)
                            }
                            onDateSelected(calendar)
                            onDismiss()
                        }
                    }
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FarmerAdd() {
    var cropName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("Kg") }
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    var cropEntries by remember { mutableStateOf(listOf<CropEntry>()) }
    var showUnitMenu by remember { mutableStateOf(false) }

    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    BaseBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color.Transparent
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=110.dp, start = 16.dp ,end=16.dp),
                            colors= CardDefaults.cardColors(Color.Transparent),


                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    "Add New Crop",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color=Color(0xFFF5F5DC)

                                )

                                OutlinedTextField(
                                    value = cropName,
                                    onValueChange = { cropName = it },
                                    label = { Text("Crop Name",color=Color.Black) },
                                    modifier = Modifier.fillMaxWidth(),
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

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    OutlinedTextField(
                                        value = quantity,
                                        onValueChange = { quantity = it },
                                        label = { Text("Quantity",color=Color.Black) },
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

                                    Box {
                                        OutlinedButton(
                                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFF5F5DC)),
                                            onClick = { showUnitMenu = true }

                                        ) {
                                            Text(unit)
                                        }

                                        DropdownMenu(
                                            expanded = showUnitMenu,
                                            onDismissRequest = { showUnitMenu = false }
                                        ) {
                                            listOf("Kg", "Ton", "Quintal").forEach { option ->
                                                DropdownMenuItem(
                                                    text = { Text(option) },
                                                    colors= MenuDefaults.itemColors(textColor = Color.Black),
                                                    onClick = {
                                                        unit = option
                                                        showUnitMenu = false
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                OutlinedTextField(
                                    value = dateFormatter.format(selectedDate.time),
                                    onValueChange = { },
                                    label = { Text("Expected Harvest Date") },
                                    modifier = Modifier.fillMaxWidth(),
                                    readOnly = true,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedContainerColor = Color(0xFFF5F5DC),
                                        unfocusedContainerColor = Color(0xFFF5F5DC),
                                        focusedTextColor = Color.Black,
                                        unfocusedTextColor = Color.Black,
                                        focusedBorderColor = Color.Black,
                                        unfocusedBorderColor = Color.Black,
                                        cursorColor = Color.Black
                                    ),
                                    trailingIcon = {
                                        IconButton(onClick = { showDatePicker = true }) {
                                            Icon(Icons.Default.DateRange, "Select date")
                                        }
                                    }
                                )

                                if (showDatePicker) {
                                    CustomDatePickerDialog(
                                        onDateSelected = { calendar ->
                                            selectedDate = calendar
                                            showDatePicker = false
                                        },
                                        onDismiss = { showDatePicker = false }
                                    )
                                }

                                Button(
                                    onClick = {
                                        if (cropName.isNotBlank() && quantity.isNotBlank()) {
                                            val newEntry = CropEntry(
                                                cropName,
                                                quantity.toFloatOrNull() ?: 0f,
                                                unit,
                                                dateFormatter.format(selectedDate.time)
                                            )
                                            cropEntries = cropEntries + newEntry
                                            cropName = ""
                                            quantity = ""
                                        }
                                    },
                                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFF5F5DC)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Icon(Icons.Default.Add, contentDescription = "Add")
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Add Crop",color=Color.Black)
                                }
                            }
                        }
                    }

                    // History Section
                    item {
                        Text(
                            "Harvest History",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }

                    items(cropEntries) { entry ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    entry.cropName,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Expected Harvest: ${entry.quantity} ${entry.unit}")
                                Text("Expected Date: ${entry.expectedHarvestDate}")
                                Text("Sold: ${entry.soldQuantity} ${entry.unit}")

                                val salePercentage = (entry.soldQuantity / entry.quantity) * 100
                                LinearProgressIndicator(
                                    progress = salePercentage / 100,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp)
                                )
                                Text(
                                    "Sale Progress: ${String.format(Locale.getDefault(), "%.1f", salePercentage)}%",
                                    color = Color.Gray
                                )
                                Button(
                                    onClick = { /* Handle creating new listing */ },
                                    modifier = Modifier
                                        .align(Alignment.End)
                                        .padding(top = 8.dp)
                                ) {
                                    Text("Create Listing")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}