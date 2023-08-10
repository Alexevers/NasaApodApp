package com.keepcoding.androidsuperpoderes.di

import com.keepcoding.androidsuperpoderes.presentation.detail.DetailViewModel
import com.keepcoding.androidsuperpoderes.presentation.list.HeroListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HeroListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
