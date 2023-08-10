package com.keepcoding.androidsuperpoderes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BaseComposableTest(
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(
            modifier = Modifier
                .height(100.dp)
                .width(20.dp)
        )
        content()
        Text("Sample")
    }
}

@Composable
fun Greeting(name: String, lastName: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .background(Color.Green)
        .padding(50.dp)
        .height(20.dp)
        .width(30.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .align(Alignment.Center)
                .size(50.dp)
        ) {

        }
        Text(
            text = "Hello $name!",
            modifier = modifier
                .alpha(0.5f)
                .background(Color.Green)
        )
        Text(text = lastName)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android", "Compose")
}