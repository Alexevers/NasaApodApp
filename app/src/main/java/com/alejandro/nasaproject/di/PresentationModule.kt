package com.alejandro.nasaproject.di

import com.alejandro.nasaproject.presentation.detail.DetailViewModel
import com.alejandro.nasaproject.presentation.list.NasaListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { NasaListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
