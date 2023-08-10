package com.alejandro.nasaproject.domain.usecase

import com.alejandro.nasaproject.data.NasaRepository

class GetNasaListUseCase(
    private val NasaRepository: NasaRepository
) {
    suspend fun invoke() = NasaRepository.getNasaList()
}
