package com.alejandro.nasaproject.data.remote

import com.alejandro.nasaproject.data.remote.dto.NasaDto

class RemoteDataSourceImpl(
    private val superNasaApi: SuperNasaApi
) : RemoteDataSource {
    override suspend fun getNasaList(): List<NasaDto> =
        superNasaApi.getNasaList()



}