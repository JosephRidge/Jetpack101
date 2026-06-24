package com.emobilis.jetpack101.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.emobilis.jetpack101.ui.theme.GOLD

/*
* This is a composable, it serves either of two purposes:
*   - Layout (Box, Row, LazyRow, LazyColumn, Column) res: https://developer.android.com/develop/ui/compose/layouts/basics
*   - UI
* */
@Composable
fun HomePage(modifier: Modifier){
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp
    val screenWidthDp = configuration.screenWidthDp.dp
    val scrollState = rememberScrollState()

    val services = arrayOf<Map<String, Any>>(
        mapOf(
            "service" to "SEO",
            "image" to "https://images.pexels.com/photos/7688453/pexels-photo-7688453.jpeg",
            "cost" to "Starts from $25"
        ),
        mapOf(
            "service" to "Marketing",
            "image" to "https://images.pexels.com/photos/15635398/pexels-photo-15635398.jpeg",
            "cost" to "Starts from $15"
        ),
        mapOf(
            "service" to "Web Design",
            "image" to "https://images.pexels.com/photos/32342294/pexels-photo-32342294.jpeg",
            "cost" to "Starts from $65"
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize() // fill the entire page
            .verticalScroll(scrollState)
    ){
//        image + text
        Box(
            contentAlignment =  Alignment.BottomStart,
            modifier = Modifier
                .height(screenHeightDp * 0.75f)
        ){
            AsyncImage(
                model = "https://images.pexels.com/photos/7181178/pexels-photo-7181178.jpeg",
                contentDescription = "Marketing Image",
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.7f))
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Text(
                    text =  "Getting your products to the world!".uppercase(),
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 72.sp,
                    fontSize = 64.sp,
//                    color = GOLD
                )
                Spacer(
                    Modifier.height(8.dp)
                )
                Text(
                    text = "Welcome to our marketing agency we get your products to te clients efficiently",
                    fontSize = 24.sp,
                    lineHeight = 30.sp,
                    color = GOLD
//                    fontWeight = FontWeight.Thin
                )
            }

        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Our services".uppercase(),
                fontWeight = FontWeight.ExtraBold,
                color = GOLD,
                fontSize = 28.sp
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                text = "Bringing world class marketing services to you",
                color = Color.White,
                fontWeight = FontWeight.Thin,
                fontSize = 20.sp,
                lineHeight = 34.sp
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )
        LazyRow() {
            items(services) {
                service ->
                Card(
                    modifier = Modifier.padding(horizontal = 8.dp , vertical = 12.dp),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Box(){
                        AsyncImage(
                            model = service["image"],
                            contentDescription = "Image of ${service["name"]}",
                            modifier = Modifier
                                .height(screenHeightDp * 0.25f)
                                .width(screenWidthDp * 0.5f),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier
                                .height(screenHeightDp * 0.25f)
                                .width(screenWidthDp * 0.5f)
                                .background(Color.Black.copy(alpha = 0.5f))
                                .padding(16.dp)
                        ){
                            Text(
                                text = service["service"].toString(),
                                fontSize = 28.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Card(
                             colors = CardColors(
                                 containerColor = Color.Black,
                                 contentColor= GOLD,
                                 disabledContainerColor= Color.Black,
                                 disabledContentColor= GOLD
                             ),
                                shape = RoundedCornerShape(30.dp)

                            ) {
                                Text(
                                    text = service["cost"].toString(),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = GOLD,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )

                            }
                        }


                    }
                }

            }
        }
        Spacer(
            modifier = Modifier.height(40.dp)
        )
    }
//   image with title text

//    display our services

}