package com.emobilis.jetpack101.ui.screens.contactus

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.ui.theme.GOLD

@Composable
fun ContactUsScreen(
    modifier: Modifier
){
    val configuration = LocalConfiguration.current
    val scrollState = rememberScrollState()
    val contentPadding = 16.dp

    var messageInput = rememberTextFieldState("")// remember{ mutableStateOf("") }
    var titleInput = rememberTextFieldState("")
    var phoneNumber = rememberTextFieldState("")

//        image + text
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        AsyncImage(
            model = R.drawable.contact_us,
            contentDescription = "Contact Us Image",
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.7f))
                .padding(contentPadding)
        ) {
            Text(
                text = "Coffee chat with us!".uppercase(),
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 72.sp,
                fontSize = 64.sp,
//                    color = GOLD
            )
            Spacer(
                Modifier.height(8.dp)
            )
            Text(
                text = "We belive in transparent, honest and respectful communication. You are our priority",
                fontSize = 24.sp,
                lineHeight = 30.sp,
                color = GOLD
//                    fontWeight = FontWeight.Thin
            )
        }


//     input form
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
modifier= Modifier.padding(contentPadding)
        ) {
             OutlinedTextField(
                 state = titleInput,
                 label ={
                     Text("Title")
                 },
                 leadingIcon = {
                     Icon(
                         painter = painterResource(R.drawable.title_icon),
                         contentDescription = "Input message section"
                     )
                 },
                 shape = RoundedCornerShape(30.dp),
                 modifier = Modifier.fillMaxWidth()

             )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                state = messageInput,
                label ={
                    Text("Message")
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.text_icon),
                        contentDescription = "Input message section"
                    )
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(4.dp))
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

                Row(
                     verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Send Message")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(R.drawable.send_icon),
                        contentDescription = "Send message section"
                    )
                }
            }
        }

    }
}