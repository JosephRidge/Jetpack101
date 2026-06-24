package com.emobilis.jetpack101.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emobilis.jetpack101.ui.screens.about.AboutScreen
import com.emobilis.jetpack101.ui.screens.home.HomePage
import kotlinx.serialization.Serializable

/*
* ref: https://developer.android.com/guide/navigation
* */
@Serializable
object Home
@Serializable
object About

@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier
){
    NavHost(
        navController = navHostController,
        startDestination = Home,
    ) {
        composable <Home>{ HomePage(modifier) }
        composable <About>{ AboutScreen(modifier) }
    }

}