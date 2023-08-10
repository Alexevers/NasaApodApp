package com.keepcoding.androidsuperpoderes.domain.usecase

import com.keepcoding.androidsuperpoderes.data.NasaRepository

class GetNasaLocationUseCase(
    private val NasaRepository: NasaRepository
) {

/*
    suspend fun invoke(id: String): LocationModel {
        val result = NasaRepository.getNasaLocationList(id)

        // Get Last
        // Recorrer la lista comparando el objeto de tipo data para buscar el máximo

        return result.last()
    }*/
}
