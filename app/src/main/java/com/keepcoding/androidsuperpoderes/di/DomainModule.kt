package com.keepcoding.androidsuperpoderes.di

import com.keepcoding.androidsuperpoderes.domain.usecase.GetDetailUseCase
import com.keepcoding.androidsuperpoderes.domain.usecase.GetDistanceFromNasaUseCase
import com.keepcoding.androidsuperpoderes.domain.usecase.GetNasaListUseCase
import com.keepcoding.androidsuperpoderes.domain.usecase.GetNasaLocationUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetNasaListUseCase(get()) }
    single { GetDetailUseCase(get()) }
    single { GetNasaLocationUseCase(get()) }
    single { GetDistanceFromNasaUseCase() }
}
