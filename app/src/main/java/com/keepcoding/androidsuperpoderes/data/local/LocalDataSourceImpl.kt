package com.keepcoding.androidsuperpoderes.data.local

import com.keepcoding.androidsuperpoderes.data.local.model.HeroLocal

class LocalDataSourceImpl(
    private val heroDao: HeroDao
) : LocalDataSource {

    override suspend fun insertHeroList(heroList: List<HeroLocal>) = heroDao.insertAll(heroList)

    override suspend fun getHeroList() : List<HeroLocal> = heroDao.getAll()

    override suspend fun getHeroById(id: String): HeroLocal = heroDao.getHeroById(id)
}
