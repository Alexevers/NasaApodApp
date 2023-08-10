package com.keepcoding.androidsuperpoderes.data.remote.dto

import com.squareup.moshi.Json

data class TestDto(
    @Json(name = "parentObject") val parentObject: AnotherObjectDto
)

data class AnotherObjectDto(
    @Json(name = "list") val list: List<String>
)

/*

// Sin el optional produciría una excepción de mapeo del modelo
{
    parentObject: {
        list: [
            "String1",
            "String2"
        ]
    }
}

{
        "description": "La  Legendary SuperSaiyan ",
        "photo": "http://i.annihil.us/u/prod/marvel/i/mg/b/c0/553a9abceb412/portrait_incredible.jpg",
        "name": "Broly",
        "favorite": false
    }

*/