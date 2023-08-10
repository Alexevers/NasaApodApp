package com.keepcoding.androidsuperpoderes.data

import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel

interface HeroRepository {
    suspend fun getHeroList(): List<HeroModel>

    suspend fun getHeroById(id: String) : HeroModel

}
