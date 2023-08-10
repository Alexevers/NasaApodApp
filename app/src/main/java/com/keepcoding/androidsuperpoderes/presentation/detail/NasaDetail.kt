package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
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
import kotlinx.coroutines.job


// Ejercicio en mostrar un diseño de un Nasa
// Mostrar la imagen con coil

val requester = FocusRequester()

@Composable
fun NasaDetail(
    nasa: NasaModel
) {
    /* Ejemplo de condicional en la vista
    var state by remember {
        mutableStateOf(false)
    }

    if (state) {
        // Show icon
    }
    */

    var starred by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .focusRequester(focusRequester = requester)
                .focusable(),
            placeholder = painterResource(id = R.drawable.fondo_login2),
            error = painterResource(id = R.drawable.fondo_login2),
            model = ImageRequest.Builder(LocalContext.current)
                .data(nasa.photo)
                .build(),
            contentDescription = "Imagen ${ nasa.id } "
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
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xED1F25A5)
                )
                Text(
                    text = nasa.date,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Star
            // Gestionar la semántica y los cambios de estado
            Checkbox(
                modifier = Modifier
                    .clearAndSetSemantics {
                    //.semantics {
                    contentDescription = "Hacer ${nasa.id} Favorito"
                    stateDescription = if (starred) {
                        "${nasa.id} marcado como Favorito"
                    } else {
                        "${nasa.id} desmarcado como Favorito"
                    }
                },
                checked = starred,
                onCheckedChange = {
                    starred = it
                }
            )
        }
    }

    /*
    Ejecuta el requestFocus al finalizar la composición de la vista
     */
    LaunchedEffect(Unit) {
        this.coroutineContext.job.invokeOnCompletion {
            requester.requestFocus()
        }
    }
}

@Composable
fun AndroidViewTest(nasa: NasaModel) {
    var starred by remember {
        mutableStateOf(false)
    }
    // Star
    AndroidView(
        modifier = Modifier
            .semantics {
                contentDescription = "Hacer ${nasa.id} Favorito"
                stateDescription = if (starred) {
                    "${nasa.id} marked as Favorite"
                } else {
                    "${nasa.id} marked as not Favorite"
                }
            }
            .clickable {
                val newState = !starred
                starred = newState
            },
        factory = { context ->
            StarComponent(context).apply {
                this.checked = starred
            }
        },
        update = {
            it.checked = starred
        }
    )
}


@Composable
@Preview
fun ShowNasaPreview() {
    NasaDetail(
        NasaTestDataBuilder()
            .withName("Sample name long text long text long text long textlong text long text long text")
            .withDescription(" Estamos probando la descripcion")

            .buildSingle()
    )
}
