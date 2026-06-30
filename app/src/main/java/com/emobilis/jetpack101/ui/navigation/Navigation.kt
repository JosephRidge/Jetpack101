package com.emobilis.jetpack101.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emobilis.jetpack101.ui.screens.about.AboutScreen
import com.emobilis.jetpack101.ui.screens.contactus.ContactUsScreen
import com.emobilis.jetpack101.ui.screens.home.HomePage


@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier,
    innerPaddingValues: PaddingValues
){
    NavHost(
        navController = navHostController,
        startDestination = Home
    ) {
        composable <Home>{ HomePage(modifier, innerPaddingValues) }
        composable <About>{ AboutScreen(modifier) }
        composable<ContactUs> { ContactUsScreen(modifier) }
    }

}