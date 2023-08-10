package com.keepcoding.androidsuperpoderes.di

import com.keepcoding.androidsuperpoderes.domain.usecase.GetDetailUseCase
import com.keepcoding.androidsuperpoderes.domain.usecase.GetDistanceFromHeroUseCase
import com.keepcoding.androidsuperpoderes.domain.usecase.GetHeroListUseCase
import com.keepcoding.androidsuperpoderes.domain.usecase.GetHeroLocationUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetHeroListUseCase(get()) }
    single { GetDetailUseCase(get()) }
    single { GetHeroLocationUseCase(get()) }
    single { GetDistanceFromHeroUseCase() }
}
