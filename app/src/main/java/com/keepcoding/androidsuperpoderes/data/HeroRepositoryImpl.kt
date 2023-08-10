package com.keepcoding.androidsuperpoderes.data

import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.mappers.toHeroLocal
import com.keepcoding.androidsuperpoderes.data.mappers.toHeroModel
import com.keepcoding.androidsuperpoderes.data.mappers.toLocationModel
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel
import com.keepcoding.androidsuperpoderes.ext.hasHttps

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : HeroRepository {
    override suspend fun getHeroList(): List<HeroModel> {
        val localData = localDataSource.getHeroList()

        // Lógica de coordinación de datos
        return if (localData.isNotEmpty()) {
            localData.map { it.toHeroModel() }
        } else {
            val remoteData = remoteDataSource.getHeroList().filter {
                (it.id?.isNotEmpty() == true) &&
                        (it.photo?.hasHttps() == true)
            }
            localDataSource.insertHeroList(remoteData.map { it.toHeroLocal() })

            remoteData.map {
                it.toHeroModel()
            }
        }
    }



    override suspend fun getHeroById(id: String): HeroModel =
        localDataSource.getHeroById(id).toHeroModel()
}

// Hay discrepancia entre los datos gestionarlo

/* Filtrado sin High Order Functions
        val mutable = mutableListOf<HeroDto>()
        for(heroDto in remoteData) {
            if (heroDto.id?.isNotEmpty() == true) {
                mutable.add(heroDto)
            }
        }
        */
