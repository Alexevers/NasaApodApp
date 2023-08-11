package com.alejandro.nasaproject.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alejandro.nasaproject.R
import com.alejandro.nasaproject.components.ShowError
import org.koin.androidx.compose.koinViewModel


/*
 * Pantalla de detalle para los elementos de la lista
 * Está hecha con Jetpack Compose y consta de un topbar,
 * un contenedor donde se muestra la imagen que se recoge de la API,
 * y un textfield donde se muestran los datos correspondientes a la imagen.
 *
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NasaDetailScreen(
    id: String,
    NasaDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val estado_para_nasa = NasaDetailViewModel.nasa.observeAsState() // este observeAsState correspondel elemento nasa livedata del nasaDetailViewModel
    val estado_para_error = NasaDetailViewModel.errorMessage.observeAsState() // este observeAsState correspondel elemento error livedata del nasaDetailViewModel

    NasaDetailViewModel.getNasa(id)

    if (estado_para_error.value?.isNotEmpty() == true) {
        val error = estado_para_error.value
        ShowError(error = error ?: "")
    }

    val result = estado_para_nasa.value

    //se carga la tipografia de la NASA
    val firaNasaFamily = FontFamily(
        Font(R.font.nasa, FontWeight.Light)
    )


    result?.let { nasa ->
        Scaffold(
            topBar = {
                //elemento topbar donde se situa el icono para volver a la lista desde la pantalla de detalle
                TopAppBar(
                    backgroundColor = Color(0xED1F25A5),
                    title = {
                        Text("Vista detalle", color = Color.White,fontFamily = firaNasaFamily)
                    },
                    navigationIcon = {
                        IconButton( //se define un botón de tipo icon para implementar la posibilidad de volver hacia atrás
                            modifier = Modifier.semantics {
                                  contentDescription = "Botón para ir al listado de imágenes"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null, tint = Color.White) //icono de la flecha para volver atrás
                        }
                    }
                )
            }
        ) {

            //contenedor para la imagen
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fondo_login2),
                    contentDescription = "Fondo con una imagen de cielo estrellado",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier.size(250.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(nasa.photo)
                        .build()
                        ,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Imagén llamada "+nasa.id
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                //textfield que va a contener la información
                TextField(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color(0xD5EDEDEE)),
                    value = nasa.date+"\n\n"+nasa.id+"\n\n"+nasa.description,
                    placeholder = {
                        Text("Email")
                    }, readOnly = true,
                    onValueChange = {}

                )
            }
        }
    } ?: run {
        ShowError("Unknown error")
    }

}

@Preview
@Composable
fun NasaDetailScreenPreview() {
    NasaDetailScreen(id = "") {

    }
}
