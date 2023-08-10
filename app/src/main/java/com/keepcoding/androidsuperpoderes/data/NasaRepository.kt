package com.keepcoding.androidsuperpoderes.data

import com.keepcoding.androidsuperpoderes.domain.model.NasaModel

interface NasaRepository {
    suspend fun getNasaList(): List<NasaModel>

    suspend fun getNasaById(id: String) : NasaModel

}
