package com.keepcoding.androidsuperpoderes.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keepcoding.androidsuperpoderes.presentation.detail.NasaDetailScreen
import com.keepcoding.androidsuperpoderes.presentation.forgot.ForgotPasswordScreen
import com.keepcoding.androidsuperpoderes.presentation.list.NasaListScreen
import com.keepcoding.androidsuperpoderes.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen(
            onForgotClicked = {
                navController.navigate(Screen.ForgotPasswordScreen.route)
            },
            onLoginSuccess = {
                navController.navigate(Screen.NasaListScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addForgotPasswordScreen() {
    composable(Screen.ForgotPasswordScreen.route) {
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addNasaListScreen(navController: NavHostController) {
    composable(Screen.NasaListScreen.route) {
        NasaListScreen { NasaId ->
            navController.navigate("${Screen.NasaDetailScreen.route}/$NasaId")
        }
    }
}

fun NavGraphBuilder.addNasaDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.NasaDetailScreen.route + "/{NasaId}",
        arguments = Screen.NasaDetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("NasaId") ?: ""
        NasaDetailScreen(id = id) {
            navController.popBackStack()
        }
    }
}
