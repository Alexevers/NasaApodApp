package com.alejandro.nasaproject.data

import com.alejandro.nasaproject.domain.model.NasaModel

interface NasaRepository {
    suspend fun getNasaList(): List<NasaModel>

    suspend fun getNasaById(id: String) : NasaModel

}
