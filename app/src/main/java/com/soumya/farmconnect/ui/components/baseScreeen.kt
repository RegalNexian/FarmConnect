package com.soumya.farmconnect.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BaseBackground(
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Set the background color to 2E7D32
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2E7D32))
                .statusBarsPadding()// Hex color code for #2E7D32
        )

        // Screen Content
        content()
    }
}
