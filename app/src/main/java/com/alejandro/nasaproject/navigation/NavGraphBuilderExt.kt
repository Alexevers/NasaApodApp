package com.alejandro.nasaproject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alejandro.nasaproject.presentation.detail.NasaDetailScreen
import com.alejandro.nasaproject.presentation.list.NasaListScreen
import com.alejandro.nasaproject.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen(

            onLoginSuccess = {
                navController.navigate(Screen.NasaListScreen.route)
            }
        )
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
