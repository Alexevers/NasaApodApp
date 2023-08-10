package com.keepcoding.androidsuperpoderes.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.androidsuperpoderes.NasaTestDataBuilder
import com.keepcoding.androidsuperpoderes.R
import com.keepcoding.androidsuperpoderes.components.StarComponent
import com.keepcoding.androidsuperpoderes.domain.model.NasaModel
import com.keepcoding.androidsuperpoderes.presentation.theme.globalElevation
import com.keepcoding.androidsuperpoderes.presentation.theme.globalPadding
import com.keepcoding.androidsuperpoderes.presentation.theme.globalRoundedCornerShape


// Ejercicio en mostrar un diseño de un Nasa
// Mostrar la imagen con coil
@Composable
fun ShowNasaList(
    nasa: NasaModel,
    onClick: () -> Unit
) {
    /* Ejemplo de condicional en la vista
    var state by remember {
        mutableStateOf(false)
    }

    if (state) {
        // Show icon
    }
    */

    val firaNasaFamily = FontFamily(
        Font(R.font.nasa, FontWeight.Light)
    )

    Card(
        modifier = Modifier
            .padding(globalPadding),
        elevation = globalElevation,

        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Row(
            modifier = Modifier
                .background(color = Color(0xED1F25A5))
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.fondo_login2),
                error = painterResource(id = R.drawable.fondo_login2),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(nasa.photo)
                    .build(), contentDescription = "Imagen tomada por la Nasa"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = nasa.id,
                        maxLines = 1,
                        color = Color.White,
                        overflow = TextOverflow.Ellipsis
                    , fontFamily = firaNasaFamily
                    )
                    Text(
                        text = nasa.date,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                        fontFamily = firaNasaFamily
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun ShowNasaPreview() {
    ShowNasaList(
        NasaTestDataBuilder()
            .withName("Sample name long text long text long text long textlong text long text long text")
            .withDescription("")

            .buildSingle()
    ) {
        // Nothing todo here
    }
}
