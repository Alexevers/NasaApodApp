package com.keepcoding.androidsuperpoderes.domain.usecase

import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel

class GetHeroLocationUseCase(
    private val heroRepository: HeroRepository
) {

/*
    suspend fun invoke(id: String): LocationModel {
        val result = heroRepository.getHeroLocationList(id)

        // Get Last
        // Recorrer la lista comparando el objeto de tipo data para buscar el máximo

        return result.last()
    }*/
}
