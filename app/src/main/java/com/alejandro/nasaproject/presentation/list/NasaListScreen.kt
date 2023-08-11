package com.alejandro.nasaproject.presentation.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.alejandro.nasaproject.R
import com.alejandro.nasaproject.components.ShowError
import com.alejandro.nasaproject.presentation.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun NasaListScreen(
    NasaListViewModel: NasaListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = NasaListViewModel.nasaList.observeAsState()

    val errorState = NasaListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "No funciona")
    }

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


    LazyColumn(


        modifier = Modifier
            .background(Color.Transparent)
            .padding(
            vertical = globalPadding

        ),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val nasaList = state.value
        items(nasaList?.size ?: 0) { i ->
            // Unwrap
            val item = nasaList?.get(i)
            item?.let { nasa ->
                ElementNasaList(nasa) {
                    onItemClick.invoke(nasa.id)
                }
            }
            /** Versión javera
            if (item != null) {

            }
            */

        }
    }
}

@Preview
@Composable
fun NasaListScreenPreview() {
    NasaListScreen {
        // Empty callback
    }
}
