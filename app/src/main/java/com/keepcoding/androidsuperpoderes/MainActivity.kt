package com.keepcoding.androidsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.keepcoding.androidsuperpoderes.navigation.NavigationGraph
import com.keepcoding.androidsuperpoderes.presentation.theme.AndroidSuperpoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent()
        setContent {
            AndroidSuperpoderesTheme(
                dynamicColor = false
            ) {
                NavigationGraph()
            }
        }
    }
}

