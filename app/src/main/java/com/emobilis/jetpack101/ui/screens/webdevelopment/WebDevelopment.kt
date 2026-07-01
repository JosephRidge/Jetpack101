package com.emobilis.jetpack101.ui.screens.webdevelopment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.ui.components.PageTopSection
import com.emobilis.jetpack101.ui.navigation.WebDevelopment

@Composable
fun WebDevelopment(modifier: Modifier){
    val scrollState = rememberScrollState()
    val screenHeightDp = LocalWindowInfo.current.containerSize.height.dp
    val screenWidthDp = LocalWindowInfo.current.containerSize.width.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {
        PageTopSection(
            image = R.drawable.web_design,
            title = R.string.web_design_title ,
            paragraph= R.string.web_design_text,
            imageHeight = screenHeightDp * 0.1f,
            imageWidth = screenWidthDp
        )

    }
}