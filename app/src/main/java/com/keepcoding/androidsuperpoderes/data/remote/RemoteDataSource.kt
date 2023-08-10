package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.remote.dto.NasaDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto

interface RemoteDataSource {
    suspend fun getNasaList(): List<NasaDto>

}