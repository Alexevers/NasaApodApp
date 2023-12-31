package com.alejandro.nasaproject.data

import com.alejandro.nasaproject.data.local.LocalDataSource
import com.alejandro.nasaproject.data.mappers.toNasaLocal
import com.alejandro.nasaproject.data.mappers.toNasaModel
import com.alejandro.nasaproject.data.remote.RemoteDataSource
import com.alejandro.nasaproject.domain.model.NasaModel
import com.alejandro.nasaproject.ext.hasHttps

class NasaRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NasaRepository {
    override suspend fun getNasaList(): List<NasaModel> {
        val localData = localDataSource.getNasaList()

        // Lógica de coordinación de datos
        return if (localData.isNotEmpty()) {
            localData.map { it.toNasaModel() }
        } else {
            val remoteData = remoteDataSource.getNasaList().filter {
                (it.id?.isNotEmpty() == true) &&
                        (it.photo?.hasHttps() == true)
            }
            localDataSource.insertNasaList(remoteData.map { it.toNasaLocal() })

            remoteData.map {
                it.toNasaModel()
            }
        }
    }


    override suspend fun getNasaById(id: String): NasaModel =
        localDataSource.getNasaById(id).toNasaModel()
}

// Hay discrepancia entre los datos gestionarlo

/* Filtrado sin High Order Functions
        val mutable = mutableListOf<NasaDto>()
        for(NasaDto in remoteData) {
            if (NasaDto.id?.isNotEmpty() == true) {
                mutable.add(NasaDto)
            }
        }
        */
