package com.alejandro.nasaproject.di

import com.alejandro.nasaproject.domain.usecase.GetDetailUseCase
import com.alejandro.nasaproject.domain.usecase.GetNasaListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetNasaListUseCase(get()) }
    single { GetDetailUseCase(get()) }

}
