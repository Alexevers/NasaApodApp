package com.keepcoding.androidsuperpoderes.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keepcoding.androidsuperpoderes.presentation.detail.HeroDetailScreen
import com.keepcoding.androidsuperpoderes.presentation.forgot.ForgotPasswordScreen
import com.keepcoding.androidsuperpoderes.presentation.list.HeroListScreen
import com.keepcoding.androidsuperpoderes.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen(
            onForgotClicked = {
                navController.navigate(Screen.ForgotPasswordScreen.route)
            },
            onLoginSuccess = {
                navController.navigate(Screen.HeroListScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addForgotPasswordScreen() {
    composable(Screen.ForgotPasswordScreen.route) {
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addHeroListScreen(navController: NavHostController) {
    composable(Screen.HeroListScreen.route) {
        HeroListScreen { heroId ->
            navController.navigate("${Screen.HeroDetailScreen.route}/$heroId")
        }
    }
}

fun NavGraphBuilder.addHeroDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.HeroDetailScreen.route + "/{heroId}",
        arguments = Screen.HeroDetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("heroId") ?: ""
        HeroDetailScreen(id = id) {
            navController.popBackStack()
        }
    }
}
