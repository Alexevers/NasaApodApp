package com.keepcoding.androidsuperpoderes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost( // FragmentContainerView
        navController = navController,
        startDestination = Screen.LoginScreen.route, // Igual que el startDestination
    ) {
        addLoginScreen(navController)
        addForgotPasswordScreen()
        addHeroListScreen(navController)
        addHeroDetailScreen(navController)
    }
}
