package com.keepcoding.androidsuperpoderes.data.local

import com.keepcoding.androidsuperpoderes.data.local.model.NasaLocal

class LocalDataSourceImpl(
    private val NasaDao: NasaDao
) : LocalDataSource {

    override suspend fun insertNasaList(NasaList: List<NasaLocal>) = NasaDao.insertAll(NasaList)

    override suspend fun getNasaList() : List<NasaLocal> = NasaDao.getAll()

    override suspend fun getNasaById(id: String): NasaLocal = NasaDao.getNasaById(id)
}
