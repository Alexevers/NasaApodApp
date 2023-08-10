package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDto>

}