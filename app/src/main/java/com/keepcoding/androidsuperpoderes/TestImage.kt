package com.keepcoding.androidsuperpoderes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TestImage() {
    Image(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Red)
            .size(50.dp)
            .border(BorderStroke(2.dp, Color.Blue), shape = CircleShape),
        painter = painterResource(id = R.drawable.ball),
        contentDescription = "My awesome image"
    )
}

@Preview
@Composable
fun TestImagePreview() {
    TestImage()
}