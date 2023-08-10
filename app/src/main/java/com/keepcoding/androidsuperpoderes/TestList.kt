package com.keepcoding.androidsuperpoderes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TestList() {
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text("Sample Item")
            }

            items(50) {index ->
                Text(
                    modifier = Modifier.height(30.dp),
                    text = "Element $index"
                )
            }

            item {
                Text("End Item")
            }
        }
    }
}

@Composable
@Preview
fun TestListPreview() {

}
