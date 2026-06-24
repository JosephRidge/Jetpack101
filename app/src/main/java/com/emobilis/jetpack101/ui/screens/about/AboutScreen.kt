package com.emobilis.jetpack101.ui.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun AboutScreen(modifier: Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("Welcome to the about page")
        AsyncImage(
            model = "https://images.pexels.com/photos/36375611/pexels-photo-36375611.jpeg",
            contentDescription = "Chess Image",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
    }
}