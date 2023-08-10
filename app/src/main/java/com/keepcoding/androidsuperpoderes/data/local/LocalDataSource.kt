package com.keepcoding.androidsuperpoderes.data.local

import com.keepcoding.androidsuperpoderes.data.local.model.HeroLocal

interface LocalDataSource {
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHeroList() : List<HeroLocal>
    suspend fun getHeroById(id: String) : HeroLocal
}
