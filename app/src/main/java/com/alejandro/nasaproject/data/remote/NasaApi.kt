package com.alejandro.nasaproject.data.remote

import com.alejandro.nasaproject.data.remote.dto.NasaDto
import retrofit2.http.GET

interface SuperNasaApi {

    @GET("apod?api_key=yduZoIgQtiBHJafa4LHGB5BCfgdtiBnulp1fJdUq&count=20")
    suspend fun getNasaList(): List<NasaDto>


}
