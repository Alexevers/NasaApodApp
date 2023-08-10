package com.keepcoding.androidsuperpoderes.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.keepcoding.androidsuperpoderes.components.ShowError
import com.keepcoding.androidsuperpoderes.presentation.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroListScreen(
    superHeroListViewModel: HeroListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = superHeroListViewModel.heroList.observeAsState()

    val errorState = superHeroListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyColumn(


        modifier = Modifier
            .background(Color.Black)
            .padding(
            vertical = globalPadding

        ),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val heroList = state.value
        items(heroList?.size ?: 0) { i ->
            // Unwrap
            val item = heroList?.get(i)
            item?.let { hero ->
                ShowHeroList(hero) {
                    onItemClick.invoke(hero.id)
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
fun HeroListScreenPreview() {
    HeroListScreen {
        // Empty callback
    }
}
