package com.keepcoding.androidsuperpoderes.domain.usecase

import com.keepcoding.androidsuperpoderes.data.HeroRepository

class GetHeroListUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke() = heroRepository.getHeroList()
}
