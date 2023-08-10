package com.alejandro.nasaproject.data.remote

import com.alejandro.nasaproject.data.remote.dto.NasaDto
import retrofit2.http.GET

/*
const val TOKEN =
    "eyJhbGciOiJIUzI1NiIsImtpZCI6InByaXZhdGUiLCJ0eXAiOiJKV1QifQ.eyJpZGVudGlme" +
            "SI6IjdDNzQ1NjRCLTQ5NUEtNDhCRC04QzIyLTM5OEUwOUREODY0MyIsImV4cGlyYX" +
            "Rpb24iOjY0MDkyMjExMjAwLCJlbWFpbCI6Imp1YW5qZS5jaWxsYTFAZ21haWwuY29t" +
            "In0.epMHxtAkVu_fT5FvQwKrm_fRqzT9UOG2gpiTTipQajw"
*/
interface SuperNasaApi {

    @GET("apod?api_key=yduZoIgQtiBHJafa4LHGB5BCfgdtiBnulp1fJdUq&count=20")
    suspend fun getNasaList(): List<NasaDto>



    // @GET
    // @PUT
    // @DELETE
}
