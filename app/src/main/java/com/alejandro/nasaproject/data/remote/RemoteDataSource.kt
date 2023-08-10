package com.alejandro.nasaproject.data.remote

import com.alejandro.nasaproject.data.remote.dto.NasaDto

interface RemoteDataSource {
    suspend fun getNasaList(): List<NasaDto>

}