package com.keepcoding.androidsuperpoderes.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.keepcoding.androidsuperpoderes.components.ShowError
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroDetailScreen(
    id: String,
    heroDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val heroState = heroDetailViewModel.hero.observeAsState()
    val errorState = heroDetailViewModel.errorMessage.observeAsState()

    heroDetailViewModel.getHero(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = heroState.value

    // Side Effects
    // Mutabilidad
    result?.let { hero ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Detalle de ${ hero.id }")
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                  contentDescription = "Atrás Botón Ir al listado de personajes"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            ShowHeroDetail(hero = hero)
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
fun HeroDetailScreenPreview() {
    HeroDetailScreen(id = "") {

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