package com.emobilis.jetpack101.ui.screens.contactus

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.ui.components.PageTopSection
import com.emobilis.jetpack101.ui.components.contentPadding
import com.emobilis.jetpack101.ui.theme.GOLD

@Composable
fun ContactUsScreen(
    modifier: Modifier
) {
    val scrollState = rememberScrollState()
    val messageInput = rememberTextFieldState("")// remember{ mutableStateOf("") }
    val titleInput = rememberTextFieldState("")
    val phoneNumber = rememberTextFieldState("")

    val screenHeightDp = LocalWindowInfo.current.containerSize.height.dp
    val screenWidthDp = LocalWindowInfo.current.containerSize.width.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {

        PageTopSection(
            image = R.drawable.contact_us,
            title = R.string.contact_us_title,
            paragraph = R.string.contact_us_text,
            imageHeight = screenHeightDp * 0.1f,
            imageWidth = screenWidthDp
            )

//     input form
        Card(
            colors =  CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(contentPadding)
        ){
            Box(
                contentAlignment = Alignment.TopEnd
            ){
                AsyncImage(
                    model = R.drawable.form_illustration,
                    contentDescription = "Form section",
                    modifier = Modifier
                        .size(height = 150.dp, width = 150.dp)
                        .clip(RoundedCornerShape(20.dp))
//                        .background(Color.Black)
                        .padding(4.dp)
                )
                Column(
//            horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(contentPadding)
                ) {

                    Text(text = "",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Row()
                    {
                        Text(
                            text = "Feedback\ntime".uppercase(),
                            style = TextStyle(
                                fontSize = 44.sp,
                                lineHeight = 54.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    OutlinedTextField(
                        state = titleInput,
                        label = {
                            Text("Title")
                        },
                        lineLimits = TextFieldLineLimits.MultiLine(maxHeightInLines = 2),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.title_icon),
                                contentDescription = "Input message section",
                                tint = Color.Gray
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedLabelColor = Color.DarkGray,
                            focusedLabelColor = Color.Black,
                            focusedBorderColor = GOLD,
                            unfocusedBorderColor = Color.Black,
                            unfocusedTextColor = Color.DarkGray,
                            focusedTextColor = Color.Black
                        ),
                        shape = RoundedCornerShape(30.dp),
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        state = messageInput,
                        label = {
                            Text("Message")
                        },
                        lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 4, maxHeightInLines = 6),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.text_icon),
                                contentDescription = "Input message section",
                                tint = Color.Gray
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedLabelColor = Color.DarkGray,
                            focusedLabelColor = Color.Black,
                            focusedBorderColor = GOLD,
                            unfocusedBorderColor = Color.Black,
                            unfocusedTextColor = Color.DarkGray,
                            focusedTextColor = Color.Black
                        ),
                        shape = RoundedCornerShape(30.dp),
                        modifier = Modifier.fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                messageInput.clearText()
                                titleInput.clearText()
                            }, // call back function,
                            colors = ButtonColors(
                                containerColor = GOLD,
                                contentColor = Color.Black,
                                disabledContainerColor = Color.Gray,
                                disabledContentColor = Color.Black
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.send_icon),
                                contentDescription = "Send message section"
                            )
                        }
                    }
                }
            }

        }

    }
}