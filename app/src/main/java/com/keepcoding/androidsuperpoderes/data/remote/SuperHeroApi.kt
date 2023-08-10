package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.IdDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.SearchDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import com.keepcoding.androidsuperpoderes.BuildConfig
import retrofit2.http.GET

/*
const val TOKEN =
    "eyJhbGciOiJIUzI1NiIsImtpZCI6InByaXZhdGUiLCJ0eXAiOiJKV1QifQ.eyJpZGVudGlme" +
            "SI6IjdDNzQ1NjRCLTQ5NUEtNDhCRC04QzIyLTM5OEUwOUREODY0MyIsImV4cGlyYX" +
            "Rpb24iOjY0MDkyMjExMjAwLCJlbWFpbCI6Imp1YW5qZS5jaWxsYTFAZ21haWwuY29t" +
            "In0.epMHxtAkVu_fT5FvQwKrm_fRqzT9UOG2gpiTTipQajw"
*/
interface SuperHeroApi {

    @GET("apod?api_key=yduZoIgQtiBHJafa4LHGB5BCfgdtiBnulp1fJdUq&count=20")
    suspend fun getHeroList(): List<HeroDto>



    // @GET
    // @PUT
    // @DELETE
}
