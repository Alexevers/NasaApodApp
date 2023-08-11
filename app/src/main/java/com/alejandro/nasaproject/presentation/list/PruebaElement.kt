package com.alejandro.nasaproject.presentation.list


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alejandro.nasaproject.NasaTestDataBuilder
import com.alejandro.nasaproject.R
import com.alejandro.nasaproject.domain.model.NasaModel
import com.alejandro.nasaproject.presentation.theme.globalElevation
import com.alejandro.nasaproject.presentation.theme.globalPadding
import com.alejandro.nasaproject.presentation.theme.globalRoundedCornerShape


// Ejercicio en mostrar un diseño de un Nasa
// Mostrar la imagen con coil
@Composable
fun PruebaElement(
    nasa: NasaModel,
    onClick: () -> Unit
) {

    val firaNasaFamily = FontFamily(
        Font(R.font.nasa, FontWeight.Light)
    )

    Column (
        modifier = Modifier
            .background(color = Color(0xED1F25A5))
            .width(200.dp),


    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ){
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    //.size(100.dp)
                    ,
                placeholder = painterResource(id = R.drawable.fondo_login2),
                error = painterResource(id = R.drawable.fondo_login2),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(nasa.photo)
                    .build(), contentDescription = "Imagen tomada por la Nasa"
            )


        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                //.background(color = Color.Yellow)
                .padding(16.dp)
        ) {
            Text(
                text = "esto es una prueba"
                , color = Color.White
            )
        }
    }
}


@Composable
@Preview
fun PruebaElementPreview() {
    PruebaElement(
        NasaTestDataBuilder()
            .withName("Este es un texto de prueba para ver si se muestra de manera correcta")
            .withDescription("")
            .buildSingle()
    ) {

    }
}
