package com.alejandro.nasaproject.data.remote.dto

import com.squareup.moshi.Json

data class NasaDto(
    @Json(name = "title") val id: String?,
    @Json(name = "date") val date: String?,
    @Json(name = "explanation") val description: String?,
    @Json(name = "url") val photo: String?
)

/*

// Sin el optional produciría una excepción de mapeo del modelo
{
        "description": "La  Legendary SuperSaiyan ",
        "photo": "http://i.annihil.us/u/prod/marvel/i/mg/b/c0/553a9abceb412/portrait_incredible.jpg",
        "name": "Broly",
        "favorite": false
    }

*/