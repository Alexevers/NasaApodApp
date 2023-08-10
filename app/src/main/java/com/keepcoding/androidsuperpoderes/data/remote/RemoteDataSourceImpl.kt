package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.remote.dto.NasaDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.IdDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.SearchDto

class RemoteDataSourceImpl(
    private val superNasaApi: SuperNasaApi
) : RemoteDataSource {
    override suspend fun getNasaList(): List<NasaDto> =
        superNasaApi.getNasaList()



}