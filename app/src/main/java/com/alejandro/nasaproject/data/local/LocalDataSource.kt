package com.alejandro.nasaproject.data.local

import com.alejandro.nasaproject.data.local.model.NasaLocal

interface LocalDataSource {
    suspend fun insertNasaList(NasaList: List<NasaLocal>)
    suspend fun getNasaList() : List<NasaLocal>
    suspend fun getNasaById(id: String) : NasaLocal
}
