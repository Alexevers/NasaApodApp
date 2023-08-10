package com.keepcoding.androidsuperpoderes.data.local

import com.keepcoding.androidsuperpoderes.data.local.model.NasaLocal

interface LocalDataSource {
    suspend fun insertNasaList(NasaList: List<NasaLocal>)
    suspend fun getNasaList() : List<NasaLocal>
    suspend fun getNasaById(id: String) : NasaLocal
}
