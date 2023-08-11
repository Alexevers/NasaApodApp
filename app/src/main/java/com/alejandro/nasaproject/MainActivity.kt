package com.alejandro.nasaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alejandro.nasaproject.navigation.NavigationGraph
import com.alejandro.nasaproject.presentation.theme.nasaprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            nasaprojectTheme(
                dynamicColor = false
            ) {
                NavigationGraph()
            }
        }
    }
}

