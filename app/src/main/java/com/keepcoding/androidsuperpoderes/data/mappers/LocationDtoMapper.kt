package com.keepcoding.androidsuperpoderes.data.mappers

import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel
import java.util.Date

fun LocationDto.toLocationModel() = LocationModel(
    latitude = latitud!!.toDouble(),
    longitude = longitud!!.toDouble(),
    //date = Date(dateShow)
)