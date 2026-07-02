package com.emobilis.jetpack101.ui.screens.marketing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.ui.components.PageTopSection

@Composable
fun LottieAnimationComponent() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.business_goal))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { progress },
    )
}
@Composable
fun MarketingScreen(modifier: Modifier){
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
            image = R.drawable.marketing,
            title = R.string.marketing_title ,
            paragraph= R.string.marketing_text,
            imageHeight = screenHeightDp * 0.1f,
            imageWidth = screenWidthDp
        )

        LottieAnimationComponent()

    }
}