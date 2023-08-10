package com.alejandro.nasaproject.domain.usecase

import com.alejandro.nasaproject.data.NasaRepository
import com.alejandro.nasaproject.domain.model.NasaModel

class GetDetailUseCase(
    private val NasaRepository: NasaRepository
) {

    suspend fun invoke(id: String) : NasaModel = NasaRepository.getNasaById(id)

}
