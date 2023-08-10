package com.keepcoding.androidsuperpoderes.domain.usecase

import com.keepcoding.androidsuperpoderes.data.NasaRepository

class GetNasaListUseCase(
    private val NasaRepository: NasaRepository
) {
    suspend fun invoke() = NasaRepository.getNasaList()
}
