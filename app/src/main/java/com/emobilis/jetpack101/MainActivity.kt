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
import com.emobilis.jetpack101.ui.components.BottomNavigation
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