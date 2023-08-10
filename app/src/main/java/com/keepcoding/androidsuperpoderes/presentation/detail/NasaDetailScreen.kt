package com.keepcoding.androidsuperpoderes.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
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
import com.keepcoding.androidsuperpoderes.R
import com.keepcoding.androidsuperpoderes.components.ShowError
import com.keepcoding.androidsuperpoderes.presentation.login.LOGIN_TEXT_FIELD_PASSWORD
import com.keepcoding.androidsuperpoderes.presentation.login.LOGIN_TEXT_FIELD_USER
import com.keepcoding.androidsuperpoderes.presentation.login.authenticate
import org.koin.androidx.compose.koinViewModel
import java.time.format.TextStyle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NasaDetailScreen(
    id: String,
    NasaDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val nasaState = NasaDetailViewModel.nasa.observeAsState()
    val errorState = NasaDetailViewModel.errorMessage.observeAsState()

    NasaDetailViewModel.getNasa(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = nasaState.value

    val firaNasaFamily = FontFamily(
        Font(R.font.nasa, FontWeight.Light)
    )

    // Side Effects
    // Mutabilidad
    result?.let { nasa ->
        Scaffold(
            topBar = {

                TopAppBar(
                    backgroundColor = Color(0xED1F25A5),
                    title = {
                        Text("Detail Screen", color = Color.White,fontFamily = firaNasaFamily)
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                  contentDescription = "Botón para ir al listado de imágenes"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null, tint = Color.White)
                        }
                    }
                )
            }
        ) {
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


                TextField(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color(0xD5EDEDEE))


                        ,
textStyle = androidx.compose.ui.text.TextStyle(
//fontFamily = firaNasaFamily
),
                    value = nasa.date+"\n\n"+nasa.id+"\n\n"+nasa.description,

                    placeholder = {
                        Text("Email")
                    }, readOnly = true,
                    onValueChange = {}

                )
            }






            //NasaDetail(nasa = nasa)
        }
    } ?: run {
        ShowError("Unknown error")
    }

    /*
    if (result != null) {

    } else {

    }
    */

}

@Preview
@Composable
fun NasaDetailScreenPreview() {
    NasaDetailScreen(id = "") {

    }
}

/**
 * Paradigma funcional vs Paradigma Orientaión a Objetos
 * Para cada conjunto de valores de entrada siempre voy a tener la misma salida
 */
fun test(

    param1: String,
) {

}