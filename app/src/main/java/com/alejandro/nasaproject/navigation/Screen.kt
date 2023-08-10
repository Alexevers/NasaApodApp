package com.alejandro.nasaproject.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object LoginScreen : Screen(
        route = "login",
        arguments = emptyList()
    )

    object ForgotPasswordScreen : Screen(
        route = "forgotPassword",
        arguments = emptyList()
    )

    object NasaListScreen : Screen(
        route = "NasaList",
        arguments = emptyList()
    )

    object NasaDetailScreen : Screen(
        route = "NasaDetail",
        arguments = listOf(
            navArgument("NasaId") {
                type = NavType.StringType
                nullable = false
            }
        )
    )
    /*
    class OtherClass : Screen(
        "", emptyList()
    )
    */
}

//val test = Screen.OtherClass()