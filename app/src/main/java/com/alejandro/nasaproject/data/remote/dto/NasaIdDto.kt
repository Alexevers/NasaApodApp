package com.alejandro.nasaproject.data.remote.dto

import com.squareup.moshi.Json

data class NasaIdDto (
    @Json(name = "id") private val id: String?
)