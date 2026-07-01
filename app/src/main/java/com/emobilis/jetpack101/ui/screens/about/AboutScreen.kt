package com.emobilis.jetpack101.ui.screens.about

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.ui.components.PageTopSection
import com.emobilis.jetpack101.ui.components.contentPadding
import com.emobilis.jetpack101.ui.theme.GOLD

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun AboutScreen(modifier: Modifier){
    val scrollState = rememberScrollState()
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp
    val screenWidthDp = configuration.screenWidthDp.dp

    Column(
        modifier = Modifier
                .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {
        PageTopSection(
            image = R.drawable.about_us,
            title = R.string.about_us_title ,
            paragraph= R.string.about_us_text,
            imageHeight = screenHeightDp * 0.2f,
            imageWidth = screenWidthDp
        )

    }
}