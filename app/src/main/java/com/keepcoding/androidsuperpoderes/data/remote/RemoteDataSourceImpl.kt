package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.IdDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.SearchDto

class RemoteDataSourceImpl(
    private val superHeroApi: SuperHeroApi
) : RemoteDataSource {
    override suspend fun getHeroList(): List<HeroDto> =
        superHeroApi.getHeroList()



}