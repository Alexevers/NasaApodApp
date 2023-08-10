package com.keepcoding.androidsuperpoderes.data.remote.dto

import com.squareup.moshi.Json

data class LocationDto (
    @Json(name = "id") val id:String?,
    @Json(name = "dateShow") val dateShow:String?,
    @Json(name = "longitud") val longitud:String?,
    @Json(name = "latitud") val latitud:String?,
    @Json(name = "hero") val hero: HeroIdDto?
)

/*
Plain JSON:
{
        "dateShow": "2022-02-20T00:00:00Z",
        "longitud": "139.8202084625344",
        "latitud": "35.71867899343361",
        "hero": {
            "id": "D13A40E5-4418-4223-9CE6-D2F9A28EBE94"
        },
        "id": "B93A51C8-C92C-44AE-B1D1-9AFE9BA0BCCC"
    }

*/