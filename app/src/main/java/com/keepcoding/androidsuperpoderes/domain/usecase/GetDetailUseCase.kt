package com.keepcoding.androidsuperpoderes.domain.usecase

import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel

class GetDetailUseCase(
    private val heroRepository: HeroRepository
) {

    suspend fun invoke(id: String) : HeroModel = heroRepository.getHeroById(id)

}
