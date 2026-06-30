package com.emobilis.jetpack101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.emobilis.jetpack101.data.model.Route
import com.emobilis.jetpack101.ui.navigation.About
import com.emobilis.jetpack101.ui.navigation.ContactUs
import com.emobilis.jetpack101.ui.navigation.Home
import com.emobilis.jetpack101.ui.navigation.Navigation
import com.emobilis.jetpack101.ui.screens.home.HomePage
import com.emobilis.jetpack101.ui.theme.GOLD
import com.emobilis.jetpack101.ui.theme.Jetpack101Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack101Theme {
                val navController = rememberNavController() // instance of the navcontoller

                Scaffold(
                    bottomBar = { BottomNavigation(navController) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Navigation(
                        navHostController = navController,
                        modifier = Modifier.padding(innerPadding),
                        innerPadding
                    )
                }
            }
        }
    }
}

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


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "Jetpack Compose 101",
            fontSize = 24.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )

        Text(
            text = stringResource(R.string.world_cup),
            fontSize = 12.sp
        )
        AsyncImage(
            model = "https://images.pexels.com/photos/35842700/pexels-photo-35842700.jpeg",
            contentDescription = "Image of stallion",
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "Hello $name! welcome home",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = stringResource(R.string.lorem_text),
            fontSize = 14.sp,
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack101Theme {
        Greeting(modifier = Modifier, name = "Android")
    }
}