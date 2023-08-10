package com.keepcoding.androidsuperpoderes.data.remote.dto

import com.squareup.moshi.Json

data class HeroIdDto (
    @Json(name = "id") private val id: String?
)