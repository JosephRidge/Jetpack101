package com.emobilis.jetpack101.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.data.model.Route
import com.emobilis.jetpack101.ui.navigation.About
import com.emobilis.jetpack101.ui.navigation.ContactUs
import com.emobilis.jetpack101.ui.navigation.Home
import com.emobilis.jetpack101.ui.theme.GOLD

/*
* Components are reusable entities within a codebase they basically help you reduce
*  repetition in your code
* */


@Composable
fun BottomNavigation(
    navHostController: NavHostController
) {

    val routes = listOf(
        Route("Home", Home, R.drawable.baseline_home_24),
        Route("Contact Us", ContactUs, R.drawable.support_agent),
        Route("About", About, R.drawable.contact_support)
    )

    NavigationBar() {
        routes.forEach { route ->
            NavigationBarItem(
                onClick = {
                    navHostController.navigate(route.route)
                },
                label = {
                    Text(
                        text = route.name,
                        style = TextStyle(
                            color = GOLD
                        )
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(
                            route.icon
                        ),
                        tint = GOLD,
                        contentDescription = "Navigate to ${route.name}"
                    )
                }
            )
        }

    }
}

/**
 * Each page at the far top will have an image and a title, paragraph explaining more about the page itself
 */

@Composable
fun PageTopSection( image: Any?,  title: Int, paragraph:Int, imageHeight: Dp, imageWidth:Dp){
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .background(Color.Black.copy(alpha = 0.8f))
    ) {
        AsyncImage(
            model = image,
            contentDescription = stringResource(R.string.contact_us_image_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(imageHeight)
                .width(imageWidth)
        )
        Spacer(
            Modifier.height(12.dp)
        )
        Column(
            modifier = Modifier
                .padding(contentPadding)
        ) {
            Text(
                text = stringResource(title).uppercase(),
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 46.sp,
                fontSize = 36.sp,
            )
            Spacer(
                Modifier.height(8.dp)
            )
            Text(
                text = stringResource(paragraph),
                fontSize = 20.sp,
                lineHeight = 20.sp,
                color = Color.Gray
            )
            Spacer(
                Modifier.height(12.dp)
            )
        }

    }
}

/*
* Lottie animation component
*
* */
