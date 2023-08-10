package com.keepcoding.androidsuperpoderes.domain.usecase

import com.keepcoding.androidsuperpoderes.data.NasaRepository
import com.keepcoding.androidsuperpoderes.domain.model.NasaModel

class GetDetailUseCase(
    private val NasaRepository: NasaRepository
) {

    suspend fun invoke(id: String) : NasaModel = NasaRepository.getNasaById(id)

}
